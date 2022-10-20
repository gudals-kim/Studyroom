package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setId(4L);
            member.setName("HelloD");
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("gudals");

            Member delmember = em.find(Member.class, 2L);
            em.remove(delmember);

            em.persist(delmember);
            em.persist(member);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

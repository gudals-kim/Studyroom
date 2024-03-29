package hello.itemservice.repository.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.domain.Item;
import hello.itemservice.domain.QItem;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static hello.itemservice.domain.QItem.*;

/**
 * Querydsl을 사용하려면 JPAQueryFactory 가 필요하다.
 * JPAQueryFactory 는 JPA 쿼리인 JPQL을 만들기 때문에 EntityManager 가 필요하다.
 * 설정 방식은 JdbcTemplate 을 설정하는 것과 유사하다.
 * 참고로 JPAQueryFactory 를 스프링 빈으로 등록해서 사용해도 된다.
 */
@Repository
@Transactional
public class JpaItemRepositoryV3 implements ItemRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public JpaItemRepositoryV3(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = em.find(Item.class, itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Item item = em.find(Item.class, id);
        return Optional.ofNullable(item);
    }

    /**
     * findAllOld <br>
     * Querydsl을 사용해서 동적 쿼리 문제를 해결한다.
     * BooleanBuilder 를 사용해서 원하는 where 조건들을 넣어주면 된다.
     * 이 모든 것을 자바 코드로 작성하기 때문에 동적 쿼리를 매우 편리하게 작성할 수 있다.
     */
//    @Override
    public List<Item> findAllOld(ItemSearchCond cond) {

        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();


        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(itemName)){
            builder.and(item.itemName.like("%"+itemName+"%"));
        }
        if (maxPrice!=null){
            builder.and(item.price.loe(maxPrice));
        }

        List<Item> result = query
                .select(item)
                .from(item)
                .where(builder)
                .fetch();

        return result;
    }

    /**
     * findAll<br>
     * 앞서 findAllOld 에서 작성한 코드를 깔끔하게 리팩토링 했다. 다음 코드는 누가 봐도 쉽게 이해할 수 있을 것이다.<br>
     * - Querydsl에서 where(A,B) 에 다양한 조건들을 직접 넣을 수 있는데, 이렇게 넣으면 AND 조건으로 처리된다. <br>
     * - 참고로 where() 에 null 을 입력하면 해당 조건은 무시한다.<br>
     * - 이 코드의 또 다른 장점은 likeItemName() , maxPrice() 를 다른 쿼리를 작성할 때 재사용 할 수 있다는 점이다. <br>
     * - 쉽게 이야기해서 쿼리 조건을 부분적으로 모듈화 할 수 있다. 자바 코드로 개발하기 때문에 얻을 수 있는 큰 장점이다.
     */
    @Override
    public List<Item> findAll(ItemSearchCond cond) {

        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        return query
                .select(item)
                .from(item)
                .where(likeItemName(itemName), maxPrice(maxPrice))
                .fetch();
    }

    private BooleanExpression likeItemName(String itemName){
        if (StringUtils.hasText(itemName)){
            return item.itemName.like("%"+itemName+"%");
        }
        return null;
    }

    private Predicate maxPrice(Integer maxPrice) {
        if (maxPrice!=null){
            return item.price.loe(maxPrice);
        }
        return null;
    }
}

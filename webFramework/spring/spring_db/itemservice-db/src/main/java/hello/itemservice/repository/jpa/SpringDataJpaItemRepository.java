package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 스프링 데이터 JPA가 제공하는 JpaRepository 인터페이스를 인터페이스 상속 받으면 기본적인 CRUD 기능을 사용할 수 있다.
 * 그런데 이름으로 검색하거나, 가격으로 검색하는 기능은 공통으로 제공할 수 있는 기능이 아니다. 따라서 쿼리 메서드 기능을 사용하거나 @Query 를 사용해서 직접 쿼리를 실행하면 된다.
 */
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {
    /**
     * findByItemNameLike()
     * <br> - 이름 조건만 검색했을 때 사용하는 쿼리 메서드이다. 다음과 같은 JPQL이 실행된다.
     * <br> - select i from Item i where i.name like ?
     */
    List<Item> findByItemNameLike(String itemName);

    /**
     * findByPriceLessThanEqual()
     * <br> - 가격 조건만 검색했을 때 사용하는 쿼리 메서드이다. 다음과 같은 JPQL이 실행된다.
     * <br> - select i from Item i where i.price <= ?
     */
    List<Item> findByPriceLessThanEqual(Integer price);

    /**
     * findByItemNameLikeAndPriceLessThanEqual()
     * <br> - 이름과 가격 조건을 검색했을 때 사용하는 쿼리 메서드이다. 다음과 같은 JPQL이 실행된다.
     * <br> - select i from Item i where i.itemName like ? and i.price <= ?
     */
    //쿼리 메서드
    List<Item> findByItemNameAndPriceLessThanEqual(String itemName, Integer price);

    /**
     * findItems()
     * <br> - 메서드 이름으로 쿼리를 실행하는 기능은 다음과 같은 단점이 있다.
     * <br> - 1. 조건이 많으면 메서드 이름이 너무 길어진다.
     * <br> - 2. 조인 같은 복잡한 조건을 사용할 수 없다.
     * <br> - 메서드 이름으로 쿼리를 실행하는 기능은 간단한 경우에는 유용하지만, 복잡해지면 직접 JPQL 쿼리를 작성하는 것이 좋다.
     * <br>
     * <br> 쿼리를 직접 실행하려면 @Query 애노테이션을 사용하면 된다.
     * <br> - 메서드 이름으로 쿼리를 실행할 때는 파라미터를 순서대로 입력하면 되지만, 쿼리를 직접 실행할 때는 파라미터를 명시적으로 바인딩 해야 한다.
     * <br> - 파라미터 바인딩은 @Param("itemName") 애노테이션을 사용하고, 애노테이션의 값에 파라미터 이름을 주면 된다.
     */
    //쿼리 직접 실행
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName,@Param("price") Integer price);

}

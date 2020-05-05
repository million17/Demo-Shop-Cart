package application.data.repository;

import application.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT c FROM dbo_cart c " +
            "WHERE :userName IS NULL OR (c.userName = :userName)" +
            "ORDER BY c.cart_id DESC LIMIT 1",nativeQuery = true)
    Cart findByUserName(@Param("userName") String userName);
}

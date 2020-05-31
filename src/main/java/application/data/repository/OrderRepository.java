package application.data.repository;

import application.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o.* FROM dbo_order o " +
            "WHERE (:guid IS NULL OR (o.guid = :guid)) " +
            "AND (:userName IS NULL OR (o.user_name = :userName))", nativeQuery = true)
    List<Order> findOrderByGuidOrUserName(@Param("guid") String guid, @Param("userName") String userName);
}

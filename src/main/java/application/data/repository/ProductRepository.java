package application.data.repository;

import application.data.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select count(p.productId) from dbo_product p")
    long getTotalProduct();

    @Query("SELECT p FROM dbo_product p " +
            "WHERE (:categoryId IS NULL OR (p.categoryId = :categoryId ))" +
            "AND (:productName IS NULL OR UPPER(p.productName) LIKE CONCAT('%',UPPER(p.productName),'%'))" )
    Page<Product> getListProductByCategoryOrProductNameContaining(Pageable pageable, @Param("categoryId") Integer categoryId, @Param("productName") String productName);


    @Query(value = "SELECT p.* FROM dbo_product p " +
            "WHERE p.created_date < CURRENT_DATE - 5 " +
            "LIMIT 4",nativeQuery = true)
    List<Product> getListProductHot();
}

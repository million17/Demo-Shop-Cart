package application.data.repository;

import application.data.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {

    @Query(value = "SELECT * FROM dbo_product_image p_i " +
            "WHERE p_i.product_id = :productId " +
            "LIMIT 4", nativeQuery = true )
    List<ProductImage> getListProductImageByProductId(@Param("productId") Integer productId);
}

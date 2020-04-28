package application.data.repository;

import application.data.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByProductId(Integer productId);

    @Query("select p_e from dbo_product_entity  p_e " +
            "where (:productId IS NULL OR (p_e.productId = :productId )) " +
            "AND (:colorId IS NULL OR ( p_e.colorId = :colorId ))" +
            "AND (:sizeId IS NULL OR ( p_e.sizeId = :sizeId )) ")
    ProductEntity getProductColorSize(@Param("productId") Integer productId, @Param("colorId") Integer colorId, @Param("sizeId") Integer sizeId);

}

package application.data.repository;

import application.data.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Integer> {

    @Query(value = "SELECT DISTINCT s.* FROM dbo_product_entity pe " +
            "INNER JOIN dbo_size s ON (pe.size_id = s.size_id) " +
            "WHERE pe.product_id = :productId " +
            "ORDER BY s.name", nativeQuery = true)
    List<Size> getListSizeByProductId(@Param("productId") Integer productId);
}

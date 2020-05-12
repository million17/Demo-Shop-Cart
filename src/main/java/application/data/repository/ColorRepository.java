package application.data.repository;

import application.data.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    @Query(value = "SELECT DISTINCT c.* FROM dbo_color c " +
            "INNER JOIN dbo_product_entity pe ON (c.color_id = pe.color_id) " +
            "WHERE pe.product_id = :productId " +
            "ORDER BY c.name", nativeQuery = true)
    List<Color> getListColorByProductId(@Param("productId") Integer productId);
}

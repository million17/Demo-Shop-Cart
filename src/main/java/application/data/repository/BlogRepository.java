package application.data.repository;

import application.data.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "SELECT b.* FROM dbo_blog b " +
            "WHERE (:userId IS NULL OR (b.user_id = :userId)) " +
            " LIMIT 3", nativeQuery = true)
    List<Blog> getListBlogByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM dbo_blog " +
            "ORDER BY RAND() " +
            "LIMIT 3", nativeQuery = true)
    List<Blog> getListBlogByNoLoginRandom();
}

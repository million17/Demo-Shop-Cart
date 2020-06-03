package application.data.repository;

import application.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT r.* FROM dbo_user_role ur " +
            "INNER JOIN dbo_user u on (u.user_id = ur.user_id) " +
            "INNER JOIN dbo_role r on (r.role_id = ur.role_id) " +
            "WHERE ur.user_id = :id", nativeQuery = true)
    Role getRoleByUser(@Param("id") Integer userId);
}

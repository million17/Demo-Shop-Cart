package application.data.repository;

import application.data.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository  extends JpaRepository<Size,Integer> {
}

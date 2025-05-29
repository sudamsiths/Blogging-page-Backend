package Main.repository;

import Main.model.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository <BlogEntity, Integer>{
}

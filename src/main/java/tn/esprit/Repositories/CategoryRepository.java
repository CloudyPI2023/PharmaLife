package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.Category;

import java.util.List;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByArchived(boolean bool);
}

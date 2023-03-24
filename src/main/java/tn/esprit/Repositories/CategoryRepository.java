package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.Category;
@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

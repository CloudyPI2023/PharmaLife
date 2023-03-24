package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.Gift;
import tn.esprit.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}

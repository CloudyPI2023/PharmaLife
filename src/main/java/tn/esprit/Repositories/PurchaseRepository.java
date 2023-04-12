package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}

package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.Gift;
@Repository
public interface GiftRepository extends JpaRepository<Gift,Integer> {
}

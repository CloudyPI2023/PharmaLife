package tn.esprit.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.Entities.Association;

public interface AssociationRepository extends CrudRepository<Association,Integer> {
}

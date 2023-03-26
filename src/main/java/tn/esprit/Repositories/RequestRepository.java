package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request,Integer> {

}

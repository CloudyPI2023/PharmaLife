package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.User;

import java.util.List;

public interface DonationRepository extends CrudRepository<Donation, Integer> {

}

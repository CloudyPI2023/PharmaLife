package tn.esprit.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
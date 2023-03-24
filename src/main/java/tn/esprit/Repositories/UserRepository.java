package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.User;

public interface  UserRepository extends JpaRepository<User,Integer> {
}

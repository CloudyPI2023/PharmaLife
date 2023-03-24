package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.Reclamation;
import tn.esprit.Entities.User;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {
   /* @Query("SELECT r FROM Reclamation r WHERE r.userProduct =:user")
    User getReclamationByIdUser(@Param("user") User user);*/





}

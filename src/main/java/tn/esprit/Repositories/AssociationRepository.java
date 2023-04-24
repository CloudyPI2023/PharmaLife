package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.Entities.Association;
import tn.esprit.Entities.Request;

import java.util.List;

public interface AssociationRepository extends CrudRepository<Association,Integer> {


    @Query("SELECT DATEDIFF(CURRENT_DATE, a.DateAssociation) / 365 FROM Association a WHERE a.idAssociation = :id_association")
    Integer getAssociationByDateAssociation_Year(@Param("id_association") Integer id_association);
}

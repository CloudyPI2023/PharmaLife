package tn.esprit.Services;

import tn.esprit.Entities.Reclamation;
import tn.esprit.Entities.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IReclamationService {
    List<Reclamation> retrieveAllReclamations();

    Reclamation addReclamation(Reclamation r);

   // Reclamation updateReclamation (Reclamation r);

    Reclamation retrieveReclamation (Integer idReclamation);

    void deleteReclamation( Integer idReclamation);
    User getReclamationByIdUser(Integer idUser);
}

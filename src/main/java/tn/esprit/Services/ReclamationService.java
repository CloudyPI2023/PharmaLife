package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Reclamation;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.ReclamationRepository;
import tn.esprit.Repositories.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ReclamationService implements IReclamationService {
    ReclamationRepository reclamationRepository;
    UserRepository userRepository;


    //BACK
    @Override
    public List<Reclamation> retrieveAllReclamations() {

        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation r) {
        //User currentUser=reclamationRepository.getReclamationByIdUser(1);
        User currentUser=userRepository.findById(1).get();
        r.setUserProduct(currentUser);
        reclamationRepository.save(r);
        return r;
    }

    @Override
    public Reclamation retrieveReclamation(Integer idReclamation) {
        return reclamationRepository.findById(idReclamation).get();
    }

    @Override
    public void deleteReclamation(Integer idReclamation) {
        reclamationRepository.deleteById(idReclamation);

    }

    //FRONT
    @Override
    public User getReclamationByIdUser(Integer idUser) {
        return null;
    }
}

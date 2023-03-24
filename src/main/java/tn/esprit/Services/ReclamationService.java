package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Product;
import tn.esprit.Entities.Reclamation;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.ProductRepository;
import tn.esprit.Repositories.ReclamationRepository;
import tn.esprit.Repositories.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReclamationService implements IReclamationService {
    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;


    //BACK
    @Override
    public List<Reclamation> retrieveAllReclamations() {

        return reclamationRepository.findAll();
    }

    @Override

    public Reclamation addReclamation(Reclamation r) {
        Optional<User> userOptional = userRepository.findById(r.getIdUser());
        Optional<Product> productOptional = productRepository.findById(r.getIdProduct());

        if (userOptional.isPresent() && productOptional.isPresent()) {
            User currentUser = userOptional.get();
            Product rec_product = productOptional.get();
            r.setUserProduct(currentUser);
            r.setProduct(rec_product);
            r.setDateReclamation(LocalDate.now());
            reclamationRepository.save(r);
            return r;
        } else {
            throw new NoSuchElementException("User or product not found.");
        }
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

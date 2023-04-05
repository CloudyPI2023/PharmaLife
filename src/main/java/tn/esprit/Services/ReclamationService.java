package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.dao.DuplicateKeyException;
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
    @Autowired
    SendEmailReclamationService sendEmailReclamationService;


    //BACK
    @Override
    public List<Reclamation> retrieveAllReclamations() {

        return reclamationRepository.findAll();
    }

    @Override

    public Reclamation addReclamation(Reclamation r) {
        Optional<User> userOptional = userRepository.findById(r.getIdUser());
        Optional<Product> productOptional = productRepository.findById(r.getIdProduct());
        List<Reclamation> reclamationList=reclamationRepository.findAll();

        if (userOptional.isPresent() && productOptional.isPresent()) {
                User currentUser = userOptional.get();
                Product rec_product = productOptional.get();
                r.setUserProduct(currentUser);
                r.setProduct(rec_product);
                r.setDateReclamation(LocalDate.now());
            for (Reclamation re: reclamationList
                 ) {
                if(re.getUserProduct().getIdUser()==currentUser.getIdUser()){
                    throw new DuplicateKeyException("reclamation already exists with the same user");
                }

            }

            reclamationRepository.save(r);
           sendEmailReclamationService.sendEmail(currentUser.getEmail(),"RECLAMATION FOR PRODUCT "+rec_product.getNameProduct(),
                   "Dear "+currentUser.getFirstName()+" "+currentUser.getLastName()+"\n"+"Thank you for bringing to our attention the issue you are having with << "+rec_product.getNameProduct()+" >> product \n" +
                           " We apologize for any inconvenience this may have caused you.\n"+
                           "We have received your reclamation and we are currently investigating the matter. Our team is working diligently to resolve the issue as quickly as possible.\n"+
                           "PharmaLife cloudypi");
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

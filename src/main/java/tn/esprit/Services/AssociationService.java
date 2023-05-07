package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Association;
import tn.esprit.Repositories.AssociationRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class AssociationService implements IAssociationService {

    @Autowired
    AssociationRepository associationRepository;
    ///email
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String addAssociationByMail(Association a) {
        Association u = associationRepository.findByEmail(a.getEmailAssocation());
        if(u == null) {

            associationRepository.save(a);

            this.sendSimpleMail(a.getEmailAssocation());
            return "Asso added successfully";
        }
        else {
            return "Email does not exist";
        }
    }



    @Override
    public Association updateAssociation(Association a) {
        return associationRepository.save(a);
    }

    @Override
    public void deleteAssociation(Integer idAssociation) {
        associationRepository.deleteById(idAssociation);
    }

    @Override
    public String sendSimpleMail(String email) {
        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("cloudypi2023@gmail.com");
            mailMessage.setTo(email);
            mailMessage.setText("Congratulation!!\u0020\nYour Association on PharmaLIfe was successfully added on " + LocalDate.now());
            mailMessage.setSubject("CONFIRMATION");

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Override
    public Association retrieveAssociation(Integer idAssociation) {
        return associationRepository.findById(idAssociation).get();
    }

    @Override
    public HashMap<String, Integer> nombreAnneeParAssociation() {
        List<Association> associations = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();
        // int nombreAnnee =0;
        for (Association association : associations) {
            // int nombreAnnee = (int) ChronoUnit.YEARS.between(association.getDateAssociation(), LocalDateTime.now());
            String x = "gggg";
            int nombreAnnee= 5;
            //nbAnnee = associationRepository.skieurByCouleurPiste(c);
            result.put(x, nombreAnnee);
        }
        return result;
    }



    @Override
    public List<Association> getAssociationsPlusDeDeuxAns() {
        List<Association> associations = new ArrayList<>();
        associations = (List<Association>) associationRepository.findAll();
        List<Association> result = new ArrayList<>();

        for (Association a : associations) {
            int nombreAnnee = associationRepository.getAssociationByDateAssociation_Year(a.getIdAssociation());
            if(nombreAnnee >= 3){
                a.setNbAnneeAssociation(nombreAnnee);
                result.add(a);
            }
        }
        //result = (List<Association>) associationRepository.findAll();
        return result ;
    }

    @Override
    public List<Association> retrieveAllAssociations() {
        List<Association> associations = new ArrayList<>();
        associations = (List<Association>) associationRepository.findAll();
        List<Association> result = new ArrayList<>();

        for (Association a : associations) {
            int nombreAnnee = associationRepository.getAssociationByDateAssociation_Year(a.getIdAssociation());

            a.setNbAnneeAssociation(nombreAnnee);
            result.add(a);

        }
        //result = (List<Association>) associationRepository.findAll();
        return result ;
    }
    @Override
    public Association addAssociation(Association a) {
        // int nombreAnnee = associationRepository.getAssociationByDateAssociation_Year(a.getIdAssociation());
        // int nombreAnnee = 4;
        //a.setNbAnneeAssociation(nombreAnnee);
        LocalDate dateActuelle = LocalDate.now();
        int nombreAnnees = (int) ChronoUnit.YEARS.between(a.getDateAssociation(), dateActuelle);
        a.setNbAnneeAssociation(nombreAnnees);
        return associationRepository.save(a);
    }



    @Override
    public void calculerNombreAnnees() {
        LocalDate dateActuelle = LocalDate.now();
        Association a = new Association();
        int nombreAnnees = (int) ChronoUnit.YEARS.between(a.getDateAssociation(), dateActuelle);
        a.setNbAnneeAssociation(nombreAnnees);
    }


}

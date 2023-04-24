package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Association;

import tn.esprit.Entities.Request;
import tn.esprit.Entities.RequestDonationStatus;
import tn.esprit.Repositories.AssociationRepository;
import tn.esprit.Repositories.DonationRepository;
import tn.esprit.Repositories.RequestRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Slf4j
public class RequestService implements IRequestService {
    @Autowired
    private JavaMailSender javaMailSender;

    RequestRepository requestRepository;
    AssociationRepository associationRepository;

    DonationRepository donationRepository;
    @Override
    public Request addRequest(Request r) {
        LocalDate dateActuelle = LocalDate.now();
        r.setStatusRequest(RequestDonationStatus.inProgress);
        r.setDateRequest(dateActuelle);
        return requestRepository.save(r);
    }

    @Override
    public void cancelRequest(Integer idRequest) {
        requestRepository.deleteById(idRequest);
    }

    @Override
    public List<Request> retrieveMyRequests(Integer idAssociation) {
        Association association = associationRepository.findById(idAssociation).orElse(null);
        return requestRepository.getRequestByAssociation(association.getIdAssociation());
    }

    @Override
    public Request updateRequest(Request r) {

        Association a = r.getAssociation();
        // Integer idAss = r.getAssociation().getIdAssociation();
        log.info("Association deja mawjouda  " + a);
        // log.info("id Asso deja mawjouda  " + idAss);
        r.setAssociation(a);
        LocalDate dateActuelle = LocalDate.now();
        r.setDateRequest(dateActuelle);
        return requestRepository.save(r);
    }

    @Override
    public List<Request> retrieveAllRequests() {
        return (List<Request>) requestRepository.findAll();
    }

    @Override
    public String sendMailToAssociation(String email) {

        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("cloudypi2023@gmail.com");
            mailMessage.setTo(email);
            mailMessage.setText("Congratulation!!\u0020\nYour Request on PharmaLIfe was successfully added on " + LocalDate.now()
                    +"\u0020\n with status : inProgress");
            mailMessage.setSubject("REQUEST");

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
    public Request retrieveRequest(Integer idRequest) {
        return requestRepository.findById(idRequest).get();
    }


    @Override
    public List<Request> retrieveAllRequestsInProgress() {
        return requestRepository.getRequestInProgress();
    }
    @Override
    public List<Request> retrieveAllRequestsAccepted() {
        return requestRepository.getRequestAccepted();
    }
    @Override
    public List<Request> retrieveAllRequestsInRefused() {
        return requestRepository.getRequestRefused();
    }


    @Override
    public Request assignRequestToDonation(Request r, Integer idDonation) {
        r.setIdDonation(idDonation);
        return requestRepository.save(r);
    }

    @Override
    public Request updateRequestDonation(Request r) {

        return requestRepository.save(r);
        //return requestRepository.save(r);
    }


}

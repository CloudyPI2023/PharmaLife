package tn.esprit.Services;

import tn.esprit.Entities.Association;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;

import java.util.List;
import java.util.Map;

public interface IRequestService {
    //ces fonctionnamlitées sont réalisées par 'AssociationMember'
    Request addRequest (Request r);
    void cancelRequest (Integer idRequest);

    List<Request> retrieveMyRequests(Integer idAssociation);

    Request updateRequest (Request r);
    //ces fonctionnalitées sont réalisées par 'Admin'
    List<Request> retrieveAllRequests();
    //affecter une requeste a une donation
    //ordonner les requestes par priorité
    //notifications pour admin et association a chaque modification

    //Fonctionnalités automatiques
    public String sendMailToAssociation(String email);
    Request retrieveRequest(Integer idRequest);

    List<Request> retrieveAllRequestsInProgress();

    List<Request> retrieveAllRequestsAccepted();

    List<Request> retrieveAllRequestsInRefused();

    //Request assignRequestToDonation(Integer idRequest, Integer idDnation);

    //Request assignRequestToDonation(Request r, Integer idDnation);

    //Request assignRequestToDonation(Request r);

    //   Request assignRequestToDonation(Request r, Integer idDonation);

    /*@Override
        public Request assignRequestToDonation(Request r, Integer idDonation) {
            //Request r = requestRepository.findById(idRequest).get();
            //Donation d = donationRepository.findById(idDnation).get();
           // r.setIdDonation(idDnation);
            //s.getPistes().add(p);
            //return requestRepository.save(r);

            if (r != null) {
                r.setIdDonation(idDonation);
                requestRepository.save(r);
            }

            return r;
        }*/
    // Request assignRequestToDonation(Integer idRequest, Integer idDonation);

    /*@Override
        public Request assignRequestToDonation(Request r, Integer idDonation) {
            //Request r = requestRepository.findById(idRequest).get();
            //Donation d = donationRepository.findById(idDnation).get();
           // r.setIdDonation(idDnation);
            //s.getPistes().add(p);
            //return requestRepository.save(r);

            if (r != null) {
                r.setIdDonation(idDonation);
                requestRepository.save(r);
            }

            return r;
        }*/
    // Request assignRequestToDonation(Integer idDonation);

    /*@Override
        public Request assignRequestToDonation(Request r, Integer idDonation) {
            //Request r = requestRepository.findById(idRequest).get();
            //Donation d = donationRepository.findById(idDnation).get();
           // r.setIdDonation(idDnation);
            //s.getPistes().add(p);
            //return requestRepository.save(r);

            if (r != null) {
                r.setIdDonation(idDonation);
                requestRepository.save(r);
            }

            return r;
        }*/
    //Request assignRequestToDonation(Request r);

    /*@Override
        public Request assignRequestToDonation(Request r, Integer idDonation) {
            //Request r = requestRepository.findById(idRequest).get();
            //Donation d = donationRepository.findById(idDnation).get();
           // r.setIdDonation(idDnation);
            //s.getPistes().add(p);
            //return requestRepository.save(r);

            if (r != null) {
                r.setIdDonation(idDonation);
                requestRepository.save(r);
            }

            return r;
        }*/
    Request assignRequestToDonation(Request r, Integer idDonation,Integer idAssociation);

    Request updateRequestDonation(Request r);

    Map<String, Double> RequestByStatus();
    Map<String, Double> RequestByType();


    Request assignRequestToDonationInf3(Request r, Integer idAssociation);

    List<Request> findAllRequestsWhereIdDonationIsNull();

    Request assignRequestToDonationByAdmin(Request r, Integer idDonation);

    Request assignDonationToRequestByAdmin(Donation d, Integer idRequest);


}

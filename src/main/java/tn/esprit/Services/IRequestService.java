package tn.esprit.Services;

import tn.esprit.Entities.Association;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;

import java.util.List;

public interface IRequestService {

    Request addRequest (Request r);
    void cancelRequest (Integer idRequest);

    List<Request> retrieveMyRequests(Integer idAssociation);

    Request updateRequest (Request r);

    List<Request> retrieveAllRequests();

    public String sendMailToAssociation(String email);
    Request retrieveRequest(Integer idRequest);

    List<Request> retrieveAllRequestsInProgress();

    List<Request> retrieveAllRequestsAccepted();

    List<Request> retrieveAllRequestsInRefused();


    Request assignRequestToDonation(Request r, Integer idDonation);

    Request updateRequestDonation(Request r);
}

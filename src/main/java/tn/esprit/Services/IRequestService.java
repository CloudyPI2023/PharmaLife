package tn.esprit.Services;

import tn.esprit.Entities.Request;

import java.util.List;

public interface IRequestService {

    Request addRequest (Request r);
    void cancelRequest (Integer idRequest);
    Request RetrieveRequest(Integer idRequest);

    List<Request> retrieveAllRequests();

}

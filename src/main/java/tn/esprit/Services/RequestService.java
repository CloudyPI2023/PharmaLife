package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Association;
import tn.esprit.Entities.Request;
import tn.esprit.Repositories.AssociationRepository;
import tn.esprit.Repositories.RequestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService implements IRequestService {

    RequestRepository requestRepository;
    AssociationRepository associationRepository;
    @Override
    public Request addRequest(Request r) {
        return requestRepository.save(r);
    }

    @Override
    public void cancelRequest(Integer idRequest) {
        requestRepository.deleteById(idRequest);
    }


    @Override
    public List<Request> retrieveAllRequests() {
        return (List<Request>) requestRepository.findAll();
    }

    @Override
    public Request RetrieveRequest(Integer idRequest) {
        return requestRepository.findById(idRequest).get();
    }
}

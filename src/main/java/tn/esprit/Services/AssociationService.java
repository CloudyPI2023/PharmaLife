package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Association;
import tn.esprit.Repositories.AssociationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AssociationService implements IAssociationService {

    AssociationRepository associationRepository;
    @Override
    public Association addAssociation(Association a) {
        return associationRepository.save(a);
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
    public List<Association> retrieveAllAssociations() {
        return (List<Association>) associationRepository.findAll();
    }

    @Override
    public Association retrieveAssociation(Integer idAssociation) {
        return associationRepository.findById(idAssociation).get();
    }
}

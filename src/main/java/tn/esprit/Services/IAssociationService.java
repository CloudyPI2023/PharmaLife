package tn.esprit.Services;

import tn.esprit.Entities.Association;

import java.util.List;

public interface IAssociationService {

    Association addAssociation (Association a);
    Association updateAssociation (Association a);
    void deleteAssociation (Integer idAssociation);

    Association retrieveAssociation(Integer idAssociation);
    List<Association> retrieveAllAssociations();

}

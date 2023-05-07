package tn.esprit.Services;

import tn.esprit.Entities.Association;


import java.util.HashMap;
import java.util.List;

public interface IAssociationService {

    public String addAssociationByMail (Association a);
    Association addAssociation (Association a);
    Association updateAssociation (Association a);
    void deleteAssociation (Integer idAssociation);


    List<Association> retrieveAllAssociations();
    //recherche Dynamique


    /////email
    public String sendSimpleMail(String email);

    Association retrieveAssociation(Integer idAssociation);


    HashMap<String, Integer> nombreAnneeParAssociation();

    //Integer nbAnnes(Integer idAssociation);

    List<Association> getAssociationsPlusDeDeuxAns();

    void calculerNombreAnnees();


}

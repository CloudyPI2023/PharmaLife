package tn.esprit.Services;

import tn.esprit.Entities.Association;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;

import java.util.HashMap;
import java.util.List;

public interface IAssociationService {
    // ces trois fonctionnalités sont réalisées par 'AssociationMember'
    public String addAssociationByMail (Association a);
    Association addAssociation (Association a);
    Association updateAssociation (Association a);
    void deleteAssociation (Integer idAssociation);

    //Tous les users de l'app peuvent voir la lite des associations et faire une recherche dynamique
    List<Association> retrieveAllAssociations();
    //recherche Dynamique


    /////email
    public String sendSimpleMail(String email);

    Association retrieveAssociation(Integer idAssociation);

    /* @Override
         public HashMap<Association,Integer> nombreAnneeParAssociation() {
             HashMap<Association,Integer> nombreAnneeParAssociation = new HashMap<>();

             //Couleur couleurs[]= Couleur.values()
             List<Association> associations = new ArrayList<>();
             int nbAnnee =0;
             for (Association c: associations) {

                 nbAnnee = associationRepository.skieurByCouleurPiste(c);
                 nombreAnneeParAssociation.put(c.getAssociationName(), nbAnnee);

             }
             return nombreAnneeParAssociation;
         }
     */
    HashMap<String, Integer> nombreAnneeParAssociation();

    //Integer nbAnnes(Integer idAssociation);

    List<Association> getAssociationsPlusDeDeuxAns();

    void calculerNombreAnnees();

    List<Association> retrieveMyAssociations(Integer idUser);

    //List<Request> retrieveAllRequests(Integer idAssociation);

}

package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Association;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.User;
import tn.esprit.Services.IAssociationService;
import tn.esprit.Services.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/associations")
public class AssociationRestController {


    IAssociationService iAssociationService;
    IUserService iUserService;
    // ces trois fonctionnalités sont réalisées par 'AssociationMember'

    @PostMapping("/addAssociation")
    public Association addAssociation(@RequestBody Association a){
        Association association = iAssociationService.addAssociation(a);
        return association;
    }

    @PostMapping("/addAssociationByMail/{id_user}")
    public String addAssociationByMail(@RequestBody Association a, @PathVariable("id_user") Integer IdUser){
        User u = iUserService.retrieveUser(IdUser);
        a.setUserAssociation(u);
        return iAssociationService.addAssociationByMail(a);
    }

    @PostMapping("/SendEmail/{email}")
    @ResponseBody
    public void sendEmail (@PathVariable String email) {
        iAssociationService.sendSimpleMail(email);

    }

    @PutMapping("/updateAssociation")
    public Association updateAssociation(@RequestBody Association a){
        Association association = iAssociationService.updateAssociation(a);
        return association;
    }

    @DeleteMapping("deleteAssociation/{id_association}")
    public void deleteAssociation(@PathVariable("id_association") Integer IdAssociation){
        iAssociationService.deleteAssociation(IdAssociation);
    }


    //Tous les users de l'app peuvent voir la lite des associations et faire une recherche dynamique
    @GetMapping("/retrieveAllAssociations")
    public List<Association> retrieveAllAssociations(){
        List<Association> listAssociations = iAssociationService.retrieveAllAssociations();
        return listAssociations;
    }

    /*@GetMapping("/sendMail")
    public void sendMail() {
        iAssociationService.email("ziadimouna2@gmail.com","Title", "Massage");

    }*/
    @GetMapping("/retrieveAssociation/{id_association}")
    public Association retrieveAssociation(@PathVariable("id_association")Integer IdAssociation){
        return iAssociationService.retrieveAssociation(IdAssociation);
    }

    @GetMapping("/nombreAnneeParAssociation")
    public HashMap<String,Integer> nombreAnneeParAssociation(){
        return iAssociationService.nombreAnneeParAssociation();
    }

    /*@GetMapping("/nombreAnnee/{id_association}")
    public Integer nombreAnnee(@PathVariable("id_association")Integer IdAssociation){
        return iAssociationService.nbAnnes(IdAssociation);
    }*/

    @GetMapping("/retrieveAssociationsPlusTroixAns")
    public List<Association> retrieveAssociationsPlusDeuxAns(){

        return iAssociationService.getAssociationsPlusDeDeuxAns();

    }
    @GetMapping("/getMyAssociations/{idUser}")
    public List<Association> getAssociationsByUser (@PathVariable("idUser") Integer idUser)
    {
        return iAssociationService.retrieveMyAssociations(idUser);

    }

}

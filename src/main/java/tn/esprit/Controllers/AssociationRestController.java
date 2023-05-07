package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Association;
import tn.esprit.Entities.Donation;
import tn.esprit.Services.IAssociationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/associations")
public class AssociationRestController {


    IAssociationService iAssociationService;


    @PostMapping("/addAssociation")
    public Association addAssociation(@RequestBody Association a){
        Association association = iAssociationService.addAssociation(a);
        return association;
    }

    @PostMapping("/addAssociationByMail")
    public String addAssociationByMail(@RequestBody Association a){
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



    @GetMapping("/retrieveAllAssociations")
    public List<Association> retrieveAllAssociations(){
        List<Association> listAssociations = iAssociationService.retrieveAllAssociations();
        return listAssociations;
    }

    @GetMapping("/retrieveAssociation/{id_association}")
    public Association retrieveAssociation(@PathVariable("id_association")Integer IdAssociation){
        return iAssociationService.retrieveAssociation(IdAssociation);
    }

    @GetMapping("/nombreAnneeParAssociation")
    public HashMap<String,Integer> nombreAnneeParAssociation(){
        return iAssociationService.nombreAnneeParAssociation();
    }


    @GetMapping("/retrieveAssociationsPlusTroixAns")
    public List<Association> retrieveAssociationsPlusDeuxAns(){

        return iAssociationService.getAssociationsPlusDeDeuxAns();

    }

}

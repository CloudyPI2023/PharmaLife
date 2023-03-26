package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Association;
import tn.esprit.Services.IAssociationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/associations")
public class AssociationRestController {
    IAssociationService iAssociationService;


    @PostMapping("/addAssociation")
    public Association addAssociation(@RequestBody Association a){
        Association association = iAssociationService.addAssociation(a);
        return association;
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
    public Association RetrieveAssociation(@PathVariable("id_association")Integer IdAssociation){
        return iAssociationService.RetrieveAssociation(IdAssociation);
    }
}

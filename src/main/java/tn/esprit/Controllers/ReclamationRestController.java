package tn.esprit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Reclamation;
import tn.esprit.Services.IReclamationService;
import tn.esprit.Services.ReclamationService;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Reclamation")
public class ReclamationRestController {
    @Autowired
    ReclamationService reclamationService;
    @GetMapping("/all-reclamations")
    public List<Reclamation> getAllReclamtions(){
        return reclamationService.retrieveAllReclamations();
    }

    @PostMapping("/add-reclamation")
    public Reclamation addReclamation(@RequestBody Reclamation r){
        return reclamationService.addReclamation(r);
    }

    @GetMapping("/retrieve-reclamation/{idReclamation}")
    public Reclamation retrieveReclamation(@PathVariable("idReclamation") Integer idReclamation){
        return reclamationService.retrieveReclamation(idReclamation);
    }
    @DeleteMapping("/delete-reclamation/{idReclamation}")
    public void deleteReclamation(@PathVariable("idReclamation") Integer idReclamation){
       reclamationService.deleteReclamation(idReclamation);
    }

}

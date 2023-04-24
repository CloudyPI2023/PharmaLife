package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Donation;
import tn.esprit.Services.IDonationService;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/donations")

public class DonationRestController {
    IDonationService iDonationService;

    @PostMapping("/addDonation")
    public Donation addDonation(@RequestBody Donation d){
        Donation donation = iDonationService.addDonation(d);
        return donation;
    }

    @PutMapping("/updateDonation")
    public Donation updateDonation(@RequestBody Donation d){
        Donation donation = iDonationService.updateDonation(d);
        return donation;
    }

    @DeleteMapping("deleteDonation/{id_donation}")
    public void deleteDonation(@PathVariable("id_donation") Integer IdDonation){
        iDonationService.deleteDonation(IdDonation);
    }

    @GetMapping("/getMyDonations/{idUser}")
    public List<Donation> getDonationsByUser (@PathVariable("idUser") Integer idUser)
    {
        return iDonationService.retrieveMyDonations(idUser);

    }


    @GetMapping("/retrieveAllDonations")
    public List<Donation> retrieveAllDonations(){
        List<Donation> listDonations = iDonationService.retrieveAllDonations();
        return listDonations;
    }

    @GetMapping("/retrieveDonation/{id_donation}")
    public Donation retrieveDonation(@PathVariable("id_donation")Integer IdDonation){
        return iDonationService.retrieveDonation(IdDonation);
    }

    @GetMapping("/statisticsDonationStatus")
    HashMap<String, Integer> DonationsByStatus(){
        return iDonationService.DonationByStatus();
    }

}

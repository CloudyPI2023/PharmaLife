package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Donation;
import tn.esprit.Services.IDonationService;

import java.util.List;

@RestController
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

    @GetMapping("/retrieveAllDonations")
    public List<Donation> retrieveAllDonations(){
        List<Donation> listDonations = iDonationService.retrieveAllDonations();
        return listDonations;
    }

    @GetMapping("/retrieveDonation/{id_donation}")
    public Donation retrieveDonation(@PathVariable("id_donation")Integer IdDonation){
        return iDonationService.RetrieveDonation(IdDonation);
    }

}

package tn.esprit.Services;

import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;
import tn.esprit.Entities.User;

import java.util.HashMap;
import java.util.List;

public interface IDonationService {

    Donation addDonation (Donation d);
    Donation updateDonation (Donation d);
    void deleteDonation (Integer idDonation);
    List<Donation> retrieveMyDonations(Integer idUser);


    List<Donation> retrieveAllDonations();
    Donation retrieveDonation(Integer idDonation);

    HashMap<String, Integer> DonationByStatus();





}

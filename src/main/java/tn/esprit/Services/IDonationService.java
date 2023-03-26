package tn.esprit.Services;

import tn.esprit.Entities.Donation;

import java.util.List;

public interface IDonationService {

    Donation addDonation (Donation d);
    Donation updateDonation (Donation d);
    void deleteDonation (Integer idDonation);

    Donation RetrieveDonation(Integer idDonation);
    List<Donation> retrieveAllDonations();



}

package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.DonationRepository;
import tn.esprit.Repositories.UserRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class DonationService implements IDonationService {
    DonationRepository donationRepository;
    UserRepository userRepository;
    @Override
    public Donation addDonation(Donation d) {
        return donationRepository.save(d);
    }

    @Override
    public Donation updateDonation(Donation d) {
        return donationRepository.save(d);
    }

    @Override
    public void deleteDonation(Integer idDonation) {
        donationRepository.deleteById(idDonation);
    }



    @Override
    public List<Donation> retrieveAllDonations() {
        return (List<Donation>) donationRepository.findAll();
    }

    public Donation RetrieveDonation(Integer idDonation) {
        return donationRepository.findById(idDonation).get();
    }


}

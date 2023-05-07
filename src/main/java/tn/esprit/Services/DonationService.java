package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.*;
import tn.esprit.Repositories.DonationRepository;
import tn.esprit.Repositories.UserRepository;

import java.util.HashMap;
import java.util.List;


@Service
@AllArgsConstructor
public class DonationService implements IDonationService {
    DonationRepository donationRepository;
    UserRepository userRepository;
    @Override
    public Donation addDonation(Donation d) {
        d.setStatusDonation(RequestDonationStatus.inProgress);
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
    public List<Donation> retrieveMyDonations(Integer idUser) {
        User user = userRepository.findById(idUser).orElse(null) ;
        return donationRepository.getDonationsByUserDonation(user.getIdUser());
    }


    @Override
    public List<Donation> retrieveAllDonations() {
        return (List<Donation>) donationRepository.findAll();
    }

    @Override
    public Donation retrieveDonation(Integer idDonation) {
        return donationRepository.findById(idDonation).get();
    }


    @Override
    public HashMap<String, Integer> DonationByStatus() {
        HashMap<String, Integer> map=new HashMap<>();
        List<Donation> listDonations= (List<Donation>) donationRepository.findAll();
        for (Donation d:listDonations) {
            String status = d.getStatusDonation().name();
            if(map.containsKey(status)){
                map.put(status,map.get(status)+1);
            }
            else {
                map.put(status,1);
            }
        }
        return map;
    }


}

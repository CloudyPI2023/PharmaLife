package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.*;
import tn.esprit.Repositories.DonationRepository;
import tn.esprit.Repositories.RequestRepository;
import tn.esprit.Repositories.UserRepository;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.*;
import java.sql.Date;



@Service
@AllArgsConstructor
public class DonationService implements IDonationService {
    DonationRepository donationRepository;
    UserRepository userRepository;

    @Override
    public Donation addDonation(Donation d) {
        LocalDate dateActuelle = LocalDate.now();
        d.setDateDonation(dateActuelle);
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
    public List<Donation> getDisabledDonations() {
        return donationRepository.getDisabledDonations();
    }


    @Override
    public List<Donation> retrieveAllDonations() {
        return (List<Donation>) donationRepository.findAll();
    }

    @Override
    public Donation retrieveDonation(Integer idDonation) {
        return donationRepository.findById(idDonation).get();
    }


    /*@Override
    public HashMap<String, Float> DonationByStatus() {
        HashMap<String, Float> map=new HashMap<>();
        List<Donation> listDonations= (List<Donation>) donationRepository.findAll();
        Integer nbDonations = listDonations.size();
        for (Donation d:listDonations) {
            String status = d.getStatusDonation().name();
            if(map.containsKey(status)){
               map.put(status,((map.get(status)+1)/nbDonations)*100);
        //        map.put(status,(map.get(status)+1);

            }
            else {
                map.put(status, (float) ((1/nbDonations)*100));
           //     map.put(status,1);
            }
        }
       // for( HashMap<String, Integer>  m :map){

       // }
        return map;
    }*/

    public Map<String, Double> DonationByStatus() {
        List<Donation> donations = (List<Donation>) donationRepository.findAll();
        Map<String, Integer> statusCounts = new HashMap<>();
        for (Donation d : donations) {
            String status = d.getStatusDonation().toString();
            statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);
        }
        int total = donations.size();
        Map<String, Double> statusPercentages = new HashMap<>();
        for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
            String status = entry.getKey();
            int count = entry.getValue();
            double percentage = count * 100.0 / total;
            statusPercentages.put(status, percentage);
        }
        return statusPercentages;
    }

    @Override
    public Map<String, Double> DonationByType() {
        List<Donation> donations = (List<Donation>) donationRepository.findAll();
        Map<String, Integer> typeCounts = new HashMap<>();
        for (Donation d : donations) {
            String type = d.getDonationType().toString();
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }
        int total = donations.size();
        Map<String, Double> typePercentages = new HashMap<>();
        for (Map.Entry<String, Integer> entry : typeCounts.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();
            double percentage = count * 100.0 / total;
            typePercentages.put(type, percentage);
        }
        return typePercentages;
    }

    @Override
    public Map<String, Integer> getDonationStatisticsByDate() {
        List<Donation> donations = (List<Donation>) donationRepository.findAll();
        Map<String, Integer> donationStatistics = new HashMap<>();
        for (Donation donation : donations) {
            String month = getMonthFromDonationDate(Date.valueOf(donation.getDateDonation()));
            if (donationStatistics.containsKey(month)) {
                donationStatistics.put(month, donationStatistics.get(month) + 1);
            } else {
                donationStatistics.put(month, 1);
            }
        }
        return donationStatistics;
    }

    private String getMonthFromDonationDate(Date donationDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(donationDate);
        int month = calendar.get(Calendar.MONTH) + 1;
        return String.format("%02d", month);
    }

  /* @Override
    public Map<String, Map<String, Integer>> getDonationStatisticsByDate1() {
       List<Donation> donations = (List<Donation>) donationRepository.findAll();
        Map<String, Map<String, Integer>> donationStatistics = new HashMap<>();
        for (Donation donation : donations) {
            String monthYear = getMonthYearFromDonationDate1(Date.valueOf(donation.getDateDonation()));
            String[] monthYearArray = monthYear.split("-");
            String month = monthYearArray[0];
            String year = monthYearArray[1];
            if (donationStatistics.containsKey(year)) {
                Map<String, Integer> yearStatistics = donationStatistics.get(year);
                if (yearStatistics.containsKey(month)) {
                    yearStatistics.put(month, yearStatistics.get(month) + 1);
                } else {
                    yearStatistics.put(month, 1);
                }
            } else {
                Map<String, Integer> yearStatistics = new HashMap<>();
                yearStatistics.put(month, 1);
                donationStatistics.put(year, yearStatistics);
            }
        }
        return donationStatistics;
    }*/


    @Override
    public Map<String, Map<String, Integer>> getDonationStatisticsByDate1() {
        List<Donation> donations = (List<Donation>) donationRepository.findAll();
        Map<String, Map<String, Integer>> donationStatistics = new HashMap<>();
        for (Donation donation : donations) {
            String monthYear = getMonthYearFromDonationDate1(Date.valueOf(donation.getDateDonation()));
            String[] monthYearArray = monthYear.split("-");
            String month = monthYearArray[0];
            String year = monthYearArray[1];
            if (!donationStatistics.containsKey(year)) {
                // Initialize year statistics with all 12 months
                Map<String, Integer> yearStatistics = new HashMap<>();
                for (int i = 0; i < 12; i++) {
                    String monthName = new DateFormatSymbols().getMonths()[i];
                    yearStatistics.put(monthName, 0);
                }
                donationStatistics.put(year, yearStatistics);
            }
            Map<String, Integer> yearStatistics = donationStatistics.get(year);
            int count = yearStatistics.get(month);
            yearStatistics.put(month, count + 1);
        }
        return donationStatistics;
    }



    private String getMonthYearFromDonationDate1(Date donationDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(donationDate);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        String monthName = months[month];
        return monthName + "-" + year;
    }


    /*private String getMonthYearFromDonationDate1(Date donationDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(donationDate);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return String.format("%02d-%d", month, year);
    }*/




}

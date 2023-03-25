package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Gift;
import tn.esprit.Repositories.GiftRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class GiftService implements IGiftService{
    GiftRepository giftRepository;
    @Override
    public List<Gift> retrieveAllGifts() {
        return giftRepository.findAll();
    }

    @Override
    public Gift addGift(Gift g) {
        giftRepository.save(g);
        return g;
    }

    @Override
    public Gift updateGift(Gift g) {
        giftRepository.save(g);
        return g;
    }

    @Override
    public Gift retrieveGift(Integer idGift) {
        return giftRepository.findById(idGift).get();
    }

    @Override
    public void deleteGift(Integer idGift) {
        giftRepository.deleteById(idGift);

    }
}

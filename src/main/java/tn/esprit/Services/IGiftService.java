package tn.esprit.Services;

import tn.esprit.Entities.Gift;

import java.util.List;

public interface IGiftService {
    List<Gift> retrieveAllGifts();

    Gift addGift(Gift g,List<Integer> listid);

    Gift updateGift (Gift g);

    Gift retrieveGift (Integer idGift);

    void deleteGift( Integer idGift);
}

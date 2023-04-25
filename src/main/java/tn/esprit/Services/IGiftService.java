package tn.esprit.Services;

import tn.esprit.Entities.Gift;
import tn.esprit.Entities.Product;

import java.util.List;

public interface IGiftService {
    List<Gift> retrieveAllGifts();

    public Gift addGift(Gift g);

    Gift updateGift (Gift g);

    Gift retrieveGift (Integer idGift);

    void deleteGift( Integer idGift);
     Gift addProductToGift(Integer giftId, Product product);
    List<Product> getProductsByGift(Integer idGift);
    // List<Product> getProductsByGiftScheduled(Integer idGift);
}

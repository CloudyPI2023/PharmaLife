package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Gift;
import tn.esprit.Entities.Product;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.GiftRepository;
import tn.esprit.Repositories.ProductRepository;
import tn.esprit.Repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class GiftService implements IGiftService{
    @Autowired
    GiftRepository giftRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Gift> retrieveAllGifts() {
        return giftRepository.findAll();
    }

    @Override
    public Gift addGift(Gift g) {
        Optional<User> userOptional = userRepository.findById(g.getIdUser());
        List<Product> prodList= new ArrayList<>();

        if(userOptional.isPresent()){
            User usergift=userOptional.get();
            g.setProductsGift(g.getProductsGift());

            giftRepository.save(g);
            return g;
        }else{
            throw new NoSuchElementException("User not found.");
        }

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
@Override
    public Gift addProductToGift(Integer giftId, Product product) {

        Gift gift = giftRepository.findById(giftId).orElseThrow(() -> new EntityNotFoundException("Gift not found"));
        Optional<User> userOptional = userRepository.findById(gift.getIdUser());
        if(userOptional.isPresent()){
            gift.setUserGift(userOptional.get());
        }
        gift.getProductsGift().add(product);
        return giftRepository.save(gift);
    }
}

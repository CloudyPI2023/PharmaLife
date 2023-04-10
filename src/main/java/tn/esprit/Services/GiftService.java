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
    public Gift addGift(Gift g,List<Integer> listid) {
        Optional<User> userOptional = userRepository.findById(g.getIdUser());
        List<Product> prodList= new ArrayList<>();
        System.out.println("lissteee"+listid);

        if(userOptional.isPresent()){
            User usergift=userOptional.get();
            for(Integer id:listid) {
                try {
                    Product pr = productRepository.findById(id).get();
                    System.out.println(pr);
                    prodList.add(pr);
                    System.out.println("set win" + prodList);
                }catch (NoSuchElementException e){
                    System.out.println("no product found with such id");
                }
            }
            g.setProductsGift(prodList);
            g.setUserGift(usergift);
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
}

package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.Gift;
import tn.esprit.Entities.Product;

import java.util.List;
import java.util.Set;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Integer> {


    @Query("SELECT g FROM Gift g JOIN g.ProductsGift p WHERE p.idProduct =:idProduct")
    List<Product> giftByProduct(@Param("idProduct") Integer idProduct);
    @Query("SELECT p FROM Product p JOIN p.gifts g WHERE g.idGift=:idGift")
    List<Product> productsByGift(@Param("idGift") Integer idGift);



}

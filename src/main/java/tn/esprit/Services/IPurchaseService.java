package tn.esprit.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Purchase;

import java.util.List;

public interface IPurchaseService  {
    Purchase addPurchase(Purchase p);

    Purchase editPurchase(Purchase p)  throws RuntimeException;

    void deletePurchase(Long idPurchase);

    List<Purchase> retrieveAll();
}

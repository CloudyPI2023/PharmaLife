package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import tn.esprit.Entities.Purchase;
import tn.esprit.Repositories.PurchaseRepository;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class PurchaseService implements IPurchaseService  {
    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase addPurchase(Purchase p) {
        if (p.getDatePurchase() == null ) {
            throw new IllegalArgumentException("Date purchase cannot be empty");
        }
        try {
            return purchaseRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Purchase", e);
        }
    }

    @Override
    public Purchase editPurchase(Purchase p)  throws RuntimeException {

        if (p.getIdPurchase() == null) {
            throw new IllegalArgumentException("Purchase ID cannot be null");
        }

        try {
            return purchaseRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update Purchase", e);
        }
    }
    @Override
    public void deletePurchase(Long idPurchase) {
        Optional<Purchase> purchase = purchaseRepository.findById(idPurchase);

        purchase.ifPresent(p -> {
            purchaseRepository.delete(p);
            log.info("purchase with id " + idPurchase + " has been deleted");
        });

    }
    @Override
    public List<Purchase> retrieveAll() {
        return purchaseRepository.findAll();
    }

}


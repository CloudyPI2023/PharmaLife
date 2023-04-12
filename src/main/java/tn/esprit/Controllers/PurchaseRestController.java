package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Purchase;
import tn.esprit.Services.PurchaseService;
import tn.esprit.Services.IPurchaseService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@AllArgsConstructor
public class PurchaseRestController {
    private  final IPurchaseService purchaseService;

    // http://localhost:8081/all-Purchase
    @GetMapping("/all-purchases")
    public List<Purchase> getPurchase() {
        return purchaseService.retrieveAll();
    }

    // http://localhost:8081/add-Purchase
    @PostMapping("/add-purchases")
    public Purchase addPurchase(@RequestBody Purchase p) {
        return purchaseService.addPurchase(p);
    }

    // http://localhost:8081/edit-Purchase
    @PutMapping("/edit-purchases")
    public Purchase editPurchase(@RequestBody Purchase p) {
        return purchaseService.editPurchase(p);
    }

    // http://localhost:8081/delet-Purchase/id
    @DeleteMapping("/delete-purchase/{idPurchase}")
    public void deletePurchase(@PathVariable("idPurchase") Long id) {
        purchaseService.deletePurchase(id);
    }
}

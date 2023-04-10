package tn.esprit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Category;
import tn.esprit.Entities.Gift;
import tn.esprit.Services.GiftService;
import tn.esprit.Services.ICategoryService;
import tn.esprit.Services.IGiftService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Gift")

public class GiftRestController {
    @Autowired
    GiftService giftService;

    @GetMapping("/all-gifts")
    public List<Gift> getAllGifts(){
        return giftService.retrieveAllGifts();
    }

    @PostMapping("/add-gift")
    public Gift addGift(@RequestBody Gift g,@RequestBody List<Integer> listid){
        return giftService.addGift(g,listid);
    }

    @GetMapping("/retrieve-gift/{idGift}")
    public Gift retrieveGift(@PathVariable("idGift") Integer idGift){
        return giftService.retrieveGift(idGift);
    }

    @PutMapping("/update-gift")
    public Gift updateGift(@RequestBody Gift g){
        return giftService.updateGift(g);
    }
    @DeleteMapping("/delete-gift/{idGift}")
    public void deleteGift(@PathVariable("idGift") Integer idGift){
       giftService.deleteGift(idGift);
    }

}

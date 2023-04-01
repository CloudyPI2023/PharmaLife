package tn.esprit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Gift;
import tn.esprit.Entities.Product;
import tn.esprit.Services.IGiftService;
import tn.esprit.Services.IProductService;
import tn.esprit.Services.ProductService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Product")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/all-productsFront")
    public List<Product> getAllProductsFront(){

        return productService.retrieveAllProductsFront();
    }
    @GetMapping("/all-productsBack")
    public List<Product> getAllProductsBack(){

        return productService.retrieveAllProductsBack() ;
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product p){
        return productService.addProduct(p);
    }

    @GetMapping("/retrieve-product/{idProduct}")
    public Product retrieveProduct(@PathVariable("idProduct") Integer idProduct){
        return productService.retrieveProduct(idProduct);
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product p){
        return productService.updateProduct(p);
    }
    @DeleteMapping("/delete-product/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") Integer idProduct){
        productService.deleteProduct(idProduct);
    }

}

package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Product;
import tn.esprit.Repositories.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> retrieveAllProducts() {
        List<Product> allProducts=productRepository.findAll();
        List<Product> finalProducts=new ArrayList<>();
        for (Product oneProduct:allProducts) {
            if(oneProduct.getAvailabilityProduct()!=0 && oneProduct.getExpirationDateProduct().compareTo(LocalDate.now())>0){
                finalProducts.add(oneProduct);
                productRepository.save(oneProduct);
            }
        }
        return finalProducts;
    }

    @Override
    public Product addProduct(Product p) {
            if(p.getExpirationDateProduct().compareTo(LocalDate.now())<0){
                throw new RuntimeException("product expired, cannot be added");
        }
        productRepository.save(p);
        return p;
    }

    @Override
    public Product updateProduct(Product p) {
        productRepository.save(p);
        return p;
    }

    @Override
    public Product retrieveProduct(Integer idProduct) {
        return productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productRepository.deleteById(idProduct);

    }
}

package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Product;
import tn.esprit.Repositories.ProductRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product p) {
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

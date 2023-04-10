package tn.esprit.Services;

import tn.esprit.Entities.Category;
import tn.esprit.Entities.Product;

import java.util.HashMap;
import java.util.List;

public interface IProductService {
    List<Product> retrieveAllProductsFront();
    List<Product> retrieveAllProductsExpired();
    List<Product> retrieveAllProductsNotExpired();

    Product addProduct(Product p);

    Product updateProduct (Product p);

    Product retrieveProduct (Integer idProduct);

    void deleteProduct( Integer idProduct);
    HashMap<String, Integer> CategoriesByProducts();
}

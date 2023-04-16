package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Category;
import tn.esprit.Entities.Product;
import tn.esprit.Repositories.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> retrieveAllProducts(){
        List<Product> productList= productRepository.findAll();
        List<Product> newlist=new ArrayList<>();
        for (Product p:productList
             ) {
            if(p.getExpirationDateProduct().compareTo(LocalDate.now())<0 || (p.getCategoryProduct().isArchived())) {
                p.setExpired(1);
                newlist.add(p);
            }
            else{
                p.setExpired(0);
                newlist.add(p);
            }
        }
        return newlist;



    }
    @Override
    public List<Product> retrieveAllProductsExpired() {
        List<Product> allprod=productRepository.findAll();
        List<Product> prodExpired=new ArrayList<>();
        for (Product p:allprod
             ) {
            if(p.getExpirationDateProduct().compareTo(LocalDate.now())<0) {
                p.setExpired(1);
                prodExpired.add(p);
            }
        }
        return prodExpired;
    }
    @Override
    public List<Product> retrieveAllProductsNotExpired() {
        List<Product> allprod=productRepository.findAll();
        List<Product> prodNotExpired=new ArrayList<>();
        for (Product p:allprod
        ) {
            if(p.getExpirationDateProduct().compareTo(LocalDate.now())>0) {
                p.setExpired(0);
                prodNotExpired.add(p);
            }
        }
        return prodNotExpired;
    }
    @Override
    public List<Product> retrieveAllProductsFront() {
        List<Product> allProducts=productRepository.findAll();
        List<Product> finalProducts=new ArrayList<>();
        for (Product oneProduct:allProducts) {
            if(oneProduct.getQuantityProduct()!=0 && oneProduct.getExpirationDateProduct().compareTo(LocalDate.now())>0){
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
    @Override
    public HashMap<String, Integer> CategoriesByProducts() {
        HashMap<String, Integer> map=new HashMap<>();
        List<Product> listProducts=productRepository.findAll();
        for (Product p:listProducts) {
            String categoryName=p.getCategoryProduct().getNameCategory();
            if(map.containsKey(categoryName)){
                map.put(categoryName,map.get(categoryName)+1);
            }
            else {
                map.put(categoryName,1);
            }
        }
        return map;
    }

    @Override
    public HashMap<String, Integer> ProductByExpirationDate() {
        HashMap<String, Integer> map=new HashMap<>();
        List<Product> beforeProducts=productRepository.findByExpirationDateProductBefore(LocalDate.now());
        List<Product> afterProducts=productRepository.findByExpirationDateProductAfter(LocalDate.now());
        for (Product p:beforeProducts) {

                String NameProduct = p.getNameProduct();
                Integer size = beforeProducts.size();

                    map.put(NameProduct, size);

        }
        for (Product p:afterProducts) {

            String NameProduct = p.getNameProduct();
            Integer size = afterProducts.size();

                map.put(NameProduct, size);
            }

        return map;
    }
}

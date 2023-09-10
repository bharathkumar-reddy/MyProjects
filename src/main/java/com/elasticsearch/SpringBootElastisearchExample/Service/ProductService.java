package com.elasticsearch.SpringBootElastisearchExample.Service;

import com.elasticsearch.SpringBootElastisearchExample.Entity.Product;
import com.elasticsearch.SpringBootElastisearchExample.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Iterable<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product insertProudct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Product product , int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent()) {
            Product product1 = optionalProduct.get();
            product1.setPrice(product.getPrice());
            return productRepo.save(product1);
        } else {
            throw new NoSuchElementException("Product with id " + id + " not found");
        }
    }

    public  void deleteProductById(int id){
        productRepo.deleteById(id);
    }
}

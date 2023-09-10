package com.elasticsearch.SpringBootElastisearchExample.Controller;

import com.elasticsearch.SpringBootElastisearchExample.Entity.Product;
import com.elasticsearch.SpringBootElastisearchExample.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/findAll")
    Iterable<Product> findAll(){
        return productService.getProducts();
    }

    @PostMapping("/insert")
    Product inserProduct(@RequestBody Product product ){
        return productService.insertProudct(product);
    }

    @PutMapping("/updateProductbyid/{id}")
    public Product updateProductById(@PathVariable int id,@RequestBody Product product){
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/deleteProductbyid/{id}")
    public String deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
        return "ProductID record got deleted Successfully";
    }



}

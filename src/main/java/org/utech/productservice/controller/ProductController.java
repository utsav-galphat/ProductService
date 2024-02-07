package org.utech.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.utech.productservice.services.ProductService;


import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<String> getAllProducts(){
        return Collections.emptyList();
    }

//    public String getProductByCategory(String category){
//
//    }
}

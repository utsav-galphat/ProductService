package org.utech.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.utech.productservice.ResponseDto.ProductResponseDto;
import org.utech.productservice.models.Product;
import org.utech.productservice.requestDto.ProductRequestDto;
import org.utech.productservice.services.ProductService;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("ProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/products")
    public ProductResponseDto updateProduct(@RequestBody ProductRequestDto productRequest) {
        return productService.updateProduct(productRequest);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") UUID id) {
        return productService.deleteProductById(id);
    }
}

package org.utech.productservice.services;

import org.utech.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    String deleteProductById(Long id);
}

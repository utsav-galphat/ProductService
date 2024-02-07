package org.utech.productservice.services;

import java.util.List;

public interface ProductService {

    String getProductById(Long id);

    List<String> getAllProducts();

    String deleteProductById(Long id);
}

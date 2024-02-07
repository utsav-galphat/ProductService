package org.utech.productservice.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public String getProductById(Long id) {
        return "Product fetch with id: " + id;
    }

    @Override
    public List<String> getAllProducts() {
        return null;
    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }
}

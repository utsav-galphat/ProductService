package org.utech.productservice.services;

import org.springframework.stereotype.Service;
import org.utech.productservice.models.Product;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {


    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }


}

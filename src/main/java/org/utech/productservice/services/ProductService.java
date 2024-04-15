package org.utech.productservice.services;

import org.utech.productservice.ResponseDto.ProductResponseDto;
import org.utech.productservice.models.Product;
import org.utech.productservice.requestDto.ProductRequestDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponseDto getProductById(UUID id);

    List<ProductResponseDto> getAllProducts();

    String deleteProductById(UUID id);

    ProductResponseDto saveProduct(ProductRequestDto productRequest);

    ProductResponseDto updateProduct(ProductRequestDto productRequest);
}

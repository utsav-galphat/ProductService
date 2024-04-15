package org.utech.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.utech.productservice.ResponseDto.ProductResponseDto;
import org.utech.productservice.dto.FakeStoreProductDto;
import org.utech.productservice.exceptions.ProductNotFoundException;
import org.utech.productservice.models.Category;
import org.utech.productservice.models.Product;
import org.utech.productservice.requestDto.ProductRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplateBuilder restTemplateBuilder;

    private final String productUrl = "https://fakestoreapi.com/products/";

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductResponseDto getProductById(UUID id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productUrl + id, FakeStoreProductDto.class);
        if (response.getBody() == null) {
            throw new ProductNotFoundException("Product Not Found with id: " + id);
        }
//        return getProductFromFakeStoreProductDto(response.getBody());
        return null;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productUrl, FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<>();
        for (FakeStoreProductDto dto : Objects.requireNonNull(response.getBody())) {
            productList.add(getProductFromFakeStoreProductDto(dto));
        }
        return null;
    }

    @Override
    public String deleteProductById(UUID id) {
        return null;
    }

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto product) {
        return null;
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productRequest) {
        return null;
    }

    private Product getProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}

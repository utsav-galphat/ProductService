package org.utech.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.utech.productservice.dto.FakeStoreProductDto;
import org.utech.productservice.models.Category;
import org.utech.productservice.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;

    private String productUrl = "https://fakestoreapi.com/products/";

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productUrl + id, FakeStoreProductDto.class);
        Product product = getProductFromFakeStoreProductDto(response.getBody());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productUrl, FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<>();
        for (FakeStoreProductDto dto : response.getBody()) {
            productList.add(getProductFromFakeStoreProductDto(dto));
        }
        return productList;
    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }

    private Product getProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDesc(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}

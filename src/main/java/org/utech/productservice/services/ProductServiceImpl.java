package org.utech.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utech.productservice.ResponseDto.CategoryResponseDto;
import org.utech.productservice.ResponseDto.ProductResponseDto;
import org.utech.productservice.exceptions.CategoryNotFoundException;
import org.utech.productservice.exceptions.ProductNotFoundException;
import org.utech.productservice.models.Category;
import org.utech.productservice.models.Product;
import org.utech.productservice.repository.CategoryRepository;
import org.utech.productservice.repository.ProductRepository;
import org.utech.productservice.requestDto.ProductRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponseDto getProductById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductResponseDto productResponse = ProductResponseDto.builder()
                    .id(product.get().getId())
                    .title(product.get().getTitle())
                    .description(product.get().getDescription())
                    .price(product.get().getPrice())
                    .category(CategoryResponseDto.builder()
                            .title(product.get().getCategory().getTitle())
                            .build())
                    .build();
            return productResponse;
        } else throw new ProductNotFoundException("Product Not Found with id: " + id);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No Products Found");
        } else {
            List<ProductResponseDto> productResponseList = new ArrayList<>();
            for (Product product : products) {
                ProductResponseDto productResponse = ProductResponseDto.builder()
                        .id(product.getId())
                        .title(product.getTitle())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .category(CategoryResponseDto.builder()
                                .title(product.getCategory().getTitle())
                                .build())
                        .build();
                productResponseList.add(productResponse);
            }
            return productResponseList;
        }
    }

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto productRequest) {
        Category category = categoryRepository.findByTitle(productRequest.getCategory().getTitle());
        Product product = Product.builder()
                .description(productRequest.getDescription())
                .title(productRequest.getTitle())
                .price(productRequest.getPrice())
                .category(category)
                .build();

        if (category != null) {
            product.setCategory(category);
            productRepository.save(product);
        } else
            throw new CategoryNotFoundException("Category Not present: " + categoryRepository.findByTitle(productRequest.getCategory().getTitle()));

        if (productRepository.findByTitle(productRequest.getTitle()).isPresent()) {
            Product savedProduct = productRepository.findByTitle(productRequest.getTitle()).get();
            CategoryResponseDto categoryResponse = CategoryResponseDto.builder()
                    .title(savedProduct.getCategory().getTitle()).build();
            return ProductResponseDto.builder()
                    .id(savedProduct.getId())
                    .title(savedProduct.getTitle())
                    .description(savedProduct.getDescription())
                    .price(savedProduct.getPrice())
                    .category(categoryResponse)
                    .build();
        } else throw new ProductNotFoundException("Product not saved");
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productRequest) {
        Category category = categoryRepository.findByTitle(productRequest.getCategory().getTitle());
        Product product = Product.builder()
                .id(productRequest.getId())
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .category(category)
                .build();


        if (category != null) {
            product.setCategory(category);
            productRepository.save(product);
        } else
            throw new CategoryNotFoundException("Category Not present: " + categoryRepository.findByTitle(productRequest.getCategory().getTitle()));

        if (productRepository.findByTitle(productRequest.getTitle()).isPresent()) {
            Product savedProduct = productRepository.findByTitle(productRequest.getTitle()).get();
            CategoryResponseDto categoryResponse = CategoryResponseDto.builder()
                    .title(savedProduct.getCategory().getTitle()).build();
            return ProductResponseDto.builder()
                    .id(savedProduct.getId())
                    .title(savedProduct.getTitle())
                    .description(savedProduct.getDescription())
                    .price(savedProduct.getPrice())
                    .category(categoryResponse)
                    .build();
        } else throw new ProductNotFoundException("Product not saved");
    }

    @Override
    public String deleteProductById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return "Product deleted";
        } else throw new ProductNotFoundException("Product Not Found with id: " + id);
    }

}

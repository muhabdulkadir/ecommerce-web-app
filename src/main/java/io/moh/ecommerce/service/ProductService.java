package io.moh.ecommerce.service;

import io.moh.ecommerce.dto.ProductDto;
import io.moh.ecommerce.model.Category;
import io.moh.ecommerce.model.Product;
import io.moh.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public void updateProduct(int productId, ProductDto productDto, Category category) {
        Product updatedProduct = getProductFromDto(productDto, category);
        updatedProduct.setId(productId);
        productRepository.save(updatedProduct);
    }

    public Optional<ProductDto> getProductById(int productId) {
        return productRepository.findById(productId).map(ProductDto::new);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    private static Product getProductFromDto(ProductDto productDto, Category category) {
        return new Product(productDto.getProductName(),
                productDto.getImageUrl(),
                productDto.getPrice(),
                productDto.getDescription(),
                category);
    }
}

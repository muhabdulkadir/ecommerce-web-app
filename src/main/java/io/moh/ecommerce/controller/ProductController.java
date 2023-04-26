package io.moh.ecommerce.controller;

import io.moh.ecommerce.config.ApiResponse;
import io.moh.ecommerce.dto.ProductDto;
import io.moh.ecommerce.model.Category;
import io.moh.ecommerce.service.CategoryService;
import io.moh.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.getCategoryById(productDto.getCategoryId());
        return optionalCategory.map(category -> {
            productService.addProduct(productDto, category);
            return new ResponseEntity<>(new ApiResponse(true, "product has been added"), HttpStatus.CREATED);
        }).orElse(new ResponseEntity<>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> responseBody = productService.getAllProducts();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") int productId,
                                                     @Valid @RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.getCategoryById(productDto.getCategoryId());
        return optionalCategory.map(category -> {
            if (productService.getProductById(productId).isPresent()) {
                productService.updateProduct(productId, productDto, category);
                return new ResponseEntity<>(new ApiResponse(true, "product updated"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ApiResponse(false, "product does not exist"), HttpStatus.NOT_FOUND);
            }
        }).orElse(new ResponseEntity<>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteAllProducts() {
        productService.deleteAllProducts();
        return new ResponseEntity<>(new ApiResponse(true, "all products deleted"), HttpStatus.OK);
    }
}

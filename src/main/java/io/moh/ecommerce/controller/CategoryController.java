package io.moh.ecommerce.controller;

import io.moh.ecommerce.config.ApiResponse;
import io.moh.ecommerce.model.Category;
import io.moh.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.getCategory(category.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
        }

        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "category created successfully"), HttpStatus.CREATED);
    }
}

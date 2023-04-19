package io.moh.ecommerce.controller;

import io.moh.ecommerce.config.ApiResponse;
import io.moh.ecommerce.model.Category;
import io.moh.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.getCategoryByName(category.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "category created successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> responseBody = categoryService.getAllCategories();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId,
                                                      @Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.getCategoryById(category.getId()))) {
            categoryService.updateCategory(categoryId, category);
            return new ResponseEntity<>(new ApiResponse(true, "category updated"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
    }
}

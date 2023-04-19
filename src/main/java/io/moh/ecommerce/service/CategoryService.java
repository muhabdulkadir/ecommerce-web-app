package io.moh.ecommerce.service;

import io.moh.ecommerce.model.Category;
import io.moh.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(int categoryId, Category newCategory) {
        categoryRepository.findById(categoryId)
                .ifPresent(category -> {
                    category.setCategoryName(newCategory.getCategoryName());
                    category.setDescription(newCategory.getDescription());
                    category.setImageUrl(newCategory.getImageUrl());
                    categoryRepository.save(category);
                });
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }


    public Optional<Category> getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }
}

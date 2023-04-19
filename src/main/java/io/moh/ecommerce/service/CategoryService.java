package io.moh.ecommerce.service;

import io.moh.ecommerce.model.Category;
import io.moh.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}

package io.moh.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category_name")
    private @NotBlank String categoryName;
    private @NotBlank String description;
    private @NotBlank String imageUrl;

    public Category() {
    }

    public Category(@NotBlank String categoryName, @NotBlank String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(@NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl) {
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "category id=" + id +
                ", category name='" + categoryName + '\'' +
                "', description='" + description + '\'' +
                '}';
    }
}

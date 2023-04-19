package io.moh.ecommerce.dto;

import io.moh.ecommerce.model.Product;

import javax.validation.constraints.NotNull;

public class ProductDto {
    private int id;
    private @NotNull String productName;
    private @NotNull String imageUrl;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull int categoryId;


    public ProductDto(@NotNull String productName, @NotNull String imageUrl, @NotNull double price, @NotNull String description, @NotNull int categoryId) {
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setProductName(product.getProductName());
        this.setImageUrl(product.getImageUrl());
        this.setPrice(product.getPrice());
        this.setDescription(product.getDescription());
        this.setCategoryId(product.getCategory().getId());
    }

    public ProductDto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}

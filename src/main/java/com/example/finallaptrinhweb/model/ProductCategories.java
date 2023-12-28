package com.example.finallaptrinhweb.model;

public class ProductCategories {
    private int id;
    private String categoryName;
    private String description;
    private int group_id;
    private String productType;
    private boolean active;

    public ProductCategories() {
    }

    public ProductCategories(int id, String categoryName, String description, int group_id, String productType, boolean active) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.group_id = group_id;
        this.productType = productType;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProductCategories{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", group_id=" + group_id +
                ", productType='" + productType + '\'' +
                ", active=" + active +
                '}';
    }
}

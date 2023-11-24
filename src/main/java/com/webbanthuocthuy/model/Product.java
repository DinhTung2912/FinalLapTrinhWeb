package com.webbanthuocthuy.model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String productCode;
    private String productName;
    private int categoryId;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private int quantity;
    private int stockQuantity;
    private String ingredients;
    private String dosage;
    private String instructions;
    private int warrantyPeriod;
    private String productType;
    private int supplierId;
    private String imageUrl;
    private boolean active;

    // Constructor
    public Product() {
    }
    public Product(int id, String productCode, String productName, int categoryId, BigDecimal price,
                   BigDecimal discountPrice, int quantity, int stockQuantity, String ingredients, String dosage,
                   String instructions, int warrantyPeriod, String productType, int supplierId, String imageUrl,
                   boolean active) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.stockQuantity = stockQuantity;
        this.ingredients = ingredients;
        this.dosage = dosage;
        this.instructions = instructions;
        this.warrantyPeriod = warrantyPeriod;
        this.productType = productType;
        this.supplierId = supplierId;
        this.imageUrl = imageUrl;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", quantity=" + quantity +
                ", stockQuantity=" + stockQuantity +
                ", ingredients='" + ingredients + '\'' +
                ", dosage='" + dosage + '\'' +
                ", instructions='" + instructions + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                ", productType='" + productType + '\'' +
                ", supplierId=" + supplierId +
                ", imageUrl='" + imageUrl + '\'' +
                ", active=" + active +
                '}';
    }
}

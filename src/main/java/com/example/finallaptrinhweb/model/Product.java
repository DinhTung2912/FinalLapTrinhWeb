
package com.example.finallaptrinhweb.model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String productCode;
    private String productName;
    private int categoryId;
    private double price;
    private BigDecimal discountPrice;
    private int quantity;
    private String purpose;
    private String contraindications;
    private int stockQuantity;
    private String ingredients;
    private String dosage;
    private String instructions;
    private String warrantyPeriod;
    private String productType;
    private int supplierId;
    private String imageUrl;
    private boolean active;

    public Product() {
    }

    public Product(int id, String productCode, String productName, int categoryId, double price, BigDecimal discountPrice, int quantity, String purpose, String contraindications, int stockQuantity, String ingredients, String dosage, String instructions, String warrantyPeriod, String productType, int supplierId, String imageUrl, boolean active) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.purpose = purpose;
        this.contraindications = contraindications;
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
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return this.discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDosage() {
        return this.dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return this.active;
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
                ", purpose='" + purpose + '\'' +
                ", contraindications='" + contraindications + '\'' +
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

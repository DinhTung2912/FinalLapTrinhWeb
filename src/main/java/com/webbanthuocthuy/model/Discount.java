package com.webbanthuocthuy.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Discount {
    private int id;
    private int productId;
    private String discountType;
    private BigDecimal discountValue;
    private Date expirationDate;

    // Constructor
    public Discount(){

    }
    public Discount(int id, int productId, String discountType, BigDecimal discountValue, Date expirationDate) {
        this.id = id;
        this.productId = productId;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
    }

    // Các phương thức getter và setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", productId=" + productId +
                ", discountType='" + discountType + '\'' +
                ", discountValue=" + discountValue +
                ", expirationDate=" + expirationDate +
                '}';
    }
}

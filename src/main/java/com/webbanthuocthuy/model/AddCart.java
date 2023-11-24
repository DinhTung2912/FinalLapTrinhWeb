package com.webbanthuocthuy.model;

import java.sql.Timestamp;

public class AddCart {
    private int id;
    private int productId;
    private Timestamp addCartDate;

    // Constructor
    public AddCart(){

    }
    public AddCart(int id, int productId, Timestamp addCartDate) {
        this.id = id;
        this.productId = productId;
        this.addCartDate = addCartDate;
    }

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

    public Timestamp getAddCartDate() {
        return addCartDate;
    }

    public void setAddCartDate(Timestamp addCartDate) {
        this.addCartDate = addCartDate;
    }

    @Override
    public String toString() {
        return "AddCart{" +
                "id=" + id +
                ", productId=" + productId +
                ", addCartDate=" + addCartDate +
                '}';
    }
}

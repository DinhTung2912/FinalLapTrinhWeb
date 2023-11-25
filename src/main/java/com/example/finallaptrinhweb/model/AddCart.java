
package com.example.finallaptrinhweb.model;

import java.sql.Timestamp;

public class AddCart {
    private int id;
    private int productId;
    private Timestamp addCartDate;

    public AddCart() {
    }

    public AddCart(int id, int productId, Timestamp addCartDate) {
        this.id = id;
        this.productId = productId;
        this.addCartDate = addCartDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Timestamp getAddCartDate() {
        return this.addCartDate;
    }

    public void setAddCartDate(Timestamp addCartDate) {
        this.addCartDate = addCartDate;
    }

    public String toString() {
        return "AddCart{id=" + this.id + ", productId=" + this.productId + ", addCartDate=" + this.addCartDate + "}";
    }
}
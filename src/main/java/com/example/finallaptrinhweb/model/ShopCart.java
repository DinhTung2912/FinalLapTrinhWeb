
package com.example.finallaptrinhweb.model;

public class ShopCart {
    private int id;
    private int userId;
    private int addCartId;

    public ShopCart() {
    }

    public ShopCart(int id, int userId, int addCartId) {
        this.id = id;
        this.userId = userId;
        this.addCartId = addCartId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddCartId() {
        return this.addCartId;
    }

    public void setAddCartId(int addCartId) {
        this.addCartId = addCartId;
    }

    public String toString() {
        return "ShopCart{id=" + this.id + ", userId=" + this.userId + ", addCartId=" + this.addCartId + "}";
    }
}
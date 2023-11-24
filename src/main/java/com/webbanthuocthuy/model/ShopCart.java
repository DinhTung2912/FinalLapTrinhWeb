package com.webbanthuocthuy.model;

public class ShopCart {
    private int id;
    private int userId;
    private int addCartId;

    // Constructor
    public ShopCart(){

    }
    public ShopCart(int id, int userId, int addCartId) {
        this.id = id;
        this.userId = userId;
        this.addCartId = addCartId;
    }

    // Các phương thức getter và setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddCartId() {
        return addCartId;
    }

    public void setAddCartId(int addCartId) {
        this.addCartId = addCartId;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", addCartId=" + addCartId +
                '}';
    }
}

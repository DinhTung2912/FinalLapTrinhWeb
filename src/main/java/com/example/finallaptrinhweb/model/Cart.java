package com.example.finallaptrinhweb.model;

import com.example.finallaptrinhweb.dao.ProductDAO;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> products = new HashMap<>();
    private int size;
    private double totalPrice;
    private int coupon_code_id;
    private double priceSaled;
    private ProductDAO productDAO = new ProductDAO();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> products, int size, double totalPrice, int coupon_code_id, double priceSaled) {
        this.products = products;
        this.size = size;
        this.totalPrice = totalPrice;
        this.coupon_code_id = coupon_code_id;
        this.priceSaled = priceSaled;
    }

    public Map<Integer, CartItem> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, CartItem> products) {
        this.products = products;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (CartItem cartItem : products.values()) {
            total += cartItem.getTotalPrice();
        }

        return total;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCoupon_code_id() {
        return coupon_code_id;
    }

    public void setCoupon_code_id(int coupon_code_id) {
        this.coupon_code_id = coupon_code_id;
    }

//    public double getPriceSaled() {
//        double totalBeforeCoupon = getTotalPrice();
//
//        get value coupon by coupon id
//        double discount = totalBeforeCoupon * ( valueOfCoupon/ 100);
//        double totalPriceAfterCoupon = totalBeforeCoupon - discount;
//
//        return totalPriceAfterCoupon;
//    }

    public void setPriceSaled(double priceSaled) {
        this.priceSaled = priceSaled;
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;

        for (CartItem cartItem : products.values()) {
            totalQuantity += cartItem.getQuantity();
        }

        return totalQuantity;
    }

    public boolean add(int proId, int quantity) {
        if (products.containsKey(proId)) {
            return products.get(proId).incre(proId, quantity);
        }

        Product product = productDAO.getProductById(proId);
        if (product == null) return false;
        products.put(proId, new CartItem(product, quantity));
        return true;
    }

    public boolean add(int proId) {
        return add(proId, 1);
    }

    public void remove(int proId) {
        products.remove(proId);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                ", size=" + size +
                ", totalPrice=" + totalPrice +
                ", coupon_code_id=" + coupon_code_id +
                ", priceSaled=" + priceSaled +
                '}';
    }
}

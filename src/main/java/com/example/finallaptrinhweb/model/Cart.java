package com.example.finallaptrinhweb.model;

import com.example.finallaptrinhweb.dao.ProductDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<OrderProduct> getOrderProducts() {
        List<OrderProduct> orderProducts = new ArrayList<>();

        for (CartItem cartItem : products.values()) {
            orderProducts.add(cartItem.toOrderProduct());
        }

        return orderProducts;
    }
    private Discount appliedDiscount;

    // ... existing code ...

    public Discount getAppliedDiscount() {
        return appliedDiscount;
    }

    public void setAppliedDiscount(Discount discount) {
        this.appliedDiscount = discount;
    }

    // ... existing code ...

    public double getPriceSaled() {
        double totalBeforeDiscount = getTotalPrice();

        if (appliedDiscount != null) {
            BigDecimal discountValue = appliedDiscount.getDiscountValue();
            double discount = totalBeforeDiscount * (discountValue.doubleValue() / 100);
            return totalBeforeDiscount - discount;
        } else {
            return totalBeforeDiscount;
        }
    }

    public int getMaxTypeWeight() {
        int maxTypeWeight = 0;

        for (CartItem cartItem : products.values()) {
            int typeWeight = cartItem.getProduct().getTypeWeight();
            if (typeWeight > maxTypeWeight) {
                maxTypeWeight = typeWeight;
            }
        }

        return maxTypeWeight;
    }

    public boolean isEmpty() {
        return products.isEmpty();
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

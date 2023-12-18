package com.example.finallaptrinhweb.model;

import java.text.NumberFormat;
import java.util.*;

public class Util {
    public static String formatCurrency(double price) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedPrice = numberFormat.format(price);

        // Loại bỏ dấu "đ" và gạch từ chuỗi
        formattedPrice = formattedPrice.replaceAll("[đ₫,]", "");

        return formattedPrice.trim(); // Loại bỏ khoảng trắng thừa
    }

    public static void main(String[] args) {
        double price = 1234567.89;
        String formattedCurrency = formatCurrency(price);
        System.out.println(formattedCurrency);
    }
}

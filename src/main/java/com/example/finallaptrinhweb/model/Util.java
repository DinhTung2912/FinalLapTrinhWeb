package com.example.finallaptrinhweb.model;

import java.text.NumberFormat;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Util {
    public static String formatCurrency(double price) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedPrice = numberFormat.format(price);

        // Loại bỏ dấu "đ" và gạch từ chuỗi
        formattedPrice = formattedPrice.replaceAll("[đ₫,]", "");

        return formattedPrice.trim(); // Loại bỏ khoảng trắng thừa
    }
    public static String formatTimestamp(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);}


    public static void main(String[] args) {
        double price = 1234567.89;
        String formattedCurrency = formatCurrency(price);
        System.out.println(formattedCurrency);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String formattedTimestamp = formatTimestamp(timestamp);
        System.out.println(formattedTimestamp);
    }
}

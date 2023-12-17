package com.example.finallaptrinhweb.model;

import java.text.NumberFormat;
import java.util.*;
public class Util {
    public static String formatCurrency(double price) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return numberFormat.format(price);
    }
    public static void main(String[] args) {
        // Test case 1: Giá trị dương
        double price1 = 1234.56;
        testFormatCurrency(price1);

        // Test case 2: Giá trị âm
        double price2 = 45.000;
        testFormatCurrency(price2);
    }

    public static void testFormatCurrency(double price) {
        String formattedPrice = Util.formatCurrency(price);
        System.out.println("Formatted Price for " + price + ": " + formattedPrice);
    }
}

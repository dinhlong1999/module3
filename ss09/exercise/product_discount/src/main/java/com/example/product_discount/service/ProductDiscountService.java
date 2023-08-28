package com.example.product_discount.service;

public class ProductDiscountService {
    public static double discountAmount(double productPrice, double productPercent) {
        return productPrice * productPercent * 0.01;
    }

    public static double discountPrice(double productPrice, double discountAmount) {
        return productPrice - discountAmount;
    }
}

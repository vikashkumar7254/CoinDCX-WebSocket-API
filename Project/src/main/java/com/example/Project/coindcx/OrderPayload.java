package com.example.Project.coindcx;

public class OrderPayload{

    public static String createBuyPayload(double price, double triggerPrice) {
        if (price <= triggerPrice) {
            return "{\"type\":\"buy\", \"price\":" + price + "}";
        }
        return null;
    }

    public static String createSellPayload(double price, double triggerPrice) {
        if (price >= triggerPrice) {
            return "{\"type\":\"sell\", \"price\":" + price + "}";
        }
        return null;
    }

    public static String createCancelPayload() {
        return "{\"type\":\"cancel\"}";
    }
}
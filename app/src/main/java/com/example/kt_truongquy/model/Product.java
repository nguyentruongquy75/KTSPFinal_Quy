package com.example.kt_truongquy.model;

import java.util.ArrayList;

public class Product {
    String name, image;
    Integer price;
    private static ArrayList<Product> products = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String image, Integer price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static ArrayList<Product> getProducts() {
        if (products.size() == 0) {
            products.add(new Product("Sản phẩm 1", "h6", 4000));
            products.add(new Product("Sản phẩm 2", "h7", 4100));
            products.add(new Product("Sản phẩm 3", "h8", 4300));
            products.add(new Product("Sản phẩm 4", "h9", 5000));
        }

        return products;
    }
}

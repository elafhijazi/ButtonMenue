package com.example.buttonmenu;

import android.graphics.Bitmap;

public class Product {
    String name,details;
    double price;
    Bitmap image;

    public Product(String name, String details, double price, Bitmap image) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.image = image;
    }
    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

package com.example.stationeryapp;

public class StationaryItem {
    private String name;
    private int imageResource;
    private String description;
    private double price;

    public StationaryItem(String name, int imageResource, String description, double price) {
        this.name = name;
        this.imageResource = imageResource;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

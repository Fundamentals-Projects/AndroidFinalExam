package com.omug.androidfinalexam;

public class Places {
    private String place;
    private int imagePlace;
    private double amount;

    public Places(String place, int imagePlace, double amount) {
        this.place = place;
        this.imagePlace = imagePlace;
        this.amount = amount;
    }

    public String getPlace() {
        return place;
    }

    public int getImagePlace() {
        return imagePlace;
    }

    public double getAmount() {
        return amount;
    }
}

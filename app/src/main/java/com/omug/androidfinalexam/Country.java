package com.omug.androidfinalexam;

import java.util.List;

public class Country {
    private String country;
    private String capital;
    private List<Places> poi;
    private int imgCountry;

    public Country(String country, String capital, List<Places> poi, int imgCountry) {
        this.country = country;
        this.capital = capital;
        this.poi = poi;
        this.imgCountry = imgCountry;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public List<Places> getPoi() {
        return poi;
    }

    public int getImgCountry() {
        return imgCountry;
    }

    @Override
    public String toString() {
        return country;
    }
}

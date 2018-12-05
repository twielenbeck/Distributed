package com.example.movies;

public class Movies {
    private String name;
    private double rating;

    public Movies(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public Movies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}

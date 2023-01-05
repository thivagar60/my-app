package com.example.myapplication;

public class userModel {
    int id;
    String title;
    int price;
    String description;
    String rating;
    String rate;
    String count;

public userModel(int id,
    String title,
    int price,
    String description,
    String rating,
    String rate,
    String count){

    this.id = id;
    this.title = title;
    this.price = price;
    this.description = description;
    this.rating = rating;
    this.rate = rate;
    this.count = count;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

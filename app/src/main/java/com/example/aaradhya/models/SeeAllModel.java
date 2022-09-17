package com.example.aaradhya.models;

import java.io.Serializable;

public class SeeAllModel implements Serializable {

    String img_url;
    String description;
    String name;
    String rating;
    String type;
    String price;

    public SeeAllModel() {
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SeeAllModel(String img_url, String description, String name, String rating, String type, String price) {
        this.img_url = img_url;
        this.description = description;
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.price = price;
    }
}

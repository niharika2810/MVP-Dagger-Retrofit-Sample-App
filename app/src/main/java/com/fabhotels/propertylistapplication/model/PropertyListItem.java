package com.fabhotels.propertylistapplication.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class PropertyListItem extends RealmObject {
    @PrimaryKey
    private String name;
    private String city;
    private int reviewCount;
    private int price;
    private String landmark;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getLandmark() {
        return landmark;
    }

}

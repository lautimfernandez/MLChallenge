package com.example.mlchallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("price")
    @Expose
    private float price;

    @SerializedName("condition")
    @Expose
    private  String condition;

    @SerializedName("thumbnail")
    @Expose
    private  String thumbnail;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public String getThumbnail() {
        return thumbnail;
    }


}

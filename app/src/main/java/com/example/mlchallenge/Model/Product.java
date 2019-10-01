package com.example.mlchallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("condition")
    @Expose
    private  String condition;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }



    public int getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }



}

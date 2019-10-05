package com.example.mlchallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipping {

    @SerializedName("free_shipping")
    @Expose
    private boolean freeShipping;

    public boolean isFreeShipping() {
        return freeShipping;
    }
}

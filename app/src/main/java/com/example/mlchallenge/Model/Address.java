package com.example.mlchallenge.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("state_name")
    @Expose
    private String stateName;

    @SerializedName("city_name")
    @Expose
    private String cityName;


    public String getStateName() {
        return stateName;
    }

    public String getCityName() {
        return cityName;
    }
}

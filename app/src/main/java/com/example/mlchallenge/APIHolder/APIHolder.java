package com.example.mlchallenge.APIHolder;

import com.example.mlchallenge.Model.Results;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface APIHolder {


    @GET("sites/MLA/search?q=Motorola%20G6")
    Call <List<Results>> getResults();

}

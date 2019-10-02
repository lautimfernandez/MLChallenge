package com.example.mlchallenge.APIHolder;

import com.example.mlchallenge.Model.Results;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIHolder {


    @GET("sites/MLA/search")
    Call <Results> getResults(@Query("q") String query);

}

package com.example.mlchallenge.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Results {
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("results")
    @Expose
    private List<Product> results;

    public List<Product> getResults() {
        return results;
    }

    public String getQuery(){
        return query;
    }

}

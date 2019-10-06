package com.example.mlchallenge.Server;

import com.example.mlchallenge.Interface.APIHolder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MLCLient {
    public static APIHolder getMLClient() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(APIHolder.class);
    }
}

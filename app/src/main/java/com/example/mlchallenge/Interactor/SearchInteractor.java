package com.example.mlchallenge.Interactor;

import android.util.Log;

import com.example.mlchallenge.Interface.APIHolder;
import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.Model.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchInteractor {

    public interface onSearchFetched{
        void onSuccess(List<Product> products);
        void onFailure();
    }

    public void remoteFetch(final onSearchFetched listener, String query){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIHolder holder = retrofit.create(APIHolder.class);

        Call<Results> call = holder.getResults(query);


        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                List<Product> res = response.body().getResults();

                if(!response.isSuccessful() || res.size() == 0){
                    listener.onFailure();
                    return;
                }



                if(res!=null){
                    listener.onSuccess(res);
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                listener.onFailure();
                Log.e("error", t.getMessage());
            }
        });


    }
}

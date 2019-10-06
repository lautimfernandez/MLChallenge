package com.example.mlchallenge.Interactor;

import android.util.Log;

import com.example.mlchallenge.Interface.APIHolder;
import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.Model.Results;
import com.example.mlchallenge.Server.MLCLient;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchInteractor {

    public interface onSearchFetched {
        void onSuccess(List<Product> products);

        void onFailure();
    }

    public void remoteFetch(final onSearchFetched listener, String query) {
        Call<Results> call = MLCLient.getMLClient().getResults(query);


        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (!response.isSuccessful()) {
                    listener.onFailure();
                    return;
                }

                List<Product> res = response.body().getResults();

                if (res != null) {
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

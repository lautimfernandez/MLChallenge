package com.example.mlchallenge.Interactor;

import android.util.Log;

import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.Model.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetResultsCallback implements Callback<Results> {
    private SearchInteractor.OnSearchFetched listener;

    public GetResultsCallback(final SearchInteractor.OnSearchFetched listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<Results> call, Response<Results> response) {
        if (!response.isSuccessful()) {
            listener.onFailure();
            return;
        }

        List<Product> res = response.body().getResults();

        if (res != null) {
            listener.onSuccess(res);
        } else {
            listener.onFailure();
        }
    }

    @Override
    public void onFailure(Call<Results> call, Throwable t) {
        listener.onFailure();
        Log.e("error", t.getMessage());
    }
}

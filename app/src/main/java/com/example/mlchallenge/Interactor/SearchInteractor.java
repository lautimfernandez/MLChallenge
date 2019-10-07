package com.example.mlchallenge.Interactor;

import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.Model.Results;
import com.example.mlchallenge.Server.MLCLient;

import java.util.List;

import retrofit2.Call;

public class SearchInteractor {

    /**
     * This method get the client and enqueue the call
     * @param listener to make an action depends on the call result
     * @param query to get the products
     */
    public void remoteFetch(final OnSearchFetched listener, String query) {
        Call<Results> call = MLCLient.getMLClient().getResults(query);
        call.enqueue(new GetResultsCallback(listener));
    }

    public interface OnSearchFetched {

        /**
         * Success logic when search results have been fetched
         *
         * @param products response products list
         */
        void onSuccess(List<Product> products);

        /**
         * Failure logic when search have not been fetched
         */
        void onFailure();
    }
}

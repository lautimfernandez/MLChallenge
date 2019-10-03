package com.example.mlchallenge.Presenter;

import androidx.annotation.NonNull;

import com.example.mlchallenge.Base.BasePresenter;
import com.example.mlchallenge.Interface.SearchView;
import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.Model.SearchInteractor;

import java.util.List;

public class SearchPresenter extends BasePresenter implements SearchInteractor.onSearchFetched {

    private SearchView view;
    private SearchInteractor searchInteractor;

    public SearchPresenter(@NonNull SearchView view, @NonNull SearchInteractor searchInteractor){
        this.view = view;
        this.searchInteractor = searchInteractor;
    }

    public void fetchData(String query){
        view.showProgressBar();
        searchInteractor.remoteFetch(this, query);
    }

    @Override
    public void onSuccess(List<Product> products){
        view.hideProgressBar();
        view.showSearchList(products);
        //view.showSearch();
    }

    @Override
    public void onFailure(){
        view.showDataFetchErrors();
        view.hideProgressBar();
    }

}

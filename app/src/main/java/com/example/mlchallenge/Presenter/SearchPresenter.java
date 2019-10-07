package com.example.mlchallenge.Presenter;

import androidx.annotation.NonNull;

import com.example.mlchallenge.Base.BasePresenter;
import com.example.mlchallenge.Interactor.SearchInteractor;
import com.example.mlchallenge.Interface.SearchView;
import com.example.mlchallenge.Model.Product;

import java.util.List;

public class SearchPresenter extends BasePresenter implements SearchInteractor.OnSearchFetched {

    private SearchView view;
    private SearchInteractor searchInteractor;


    public SearchPresenter(@NonNull SearchView view, @NonNull SearchInteractor searchInteractor) {
        this.view = view;
        this.searchInteractor = searchInteractor;
    }

    /**
     * This method calls the inteactor's fetch method
     * @param query the query to make the fetch
     */
    public void fetchData(String query) {
        view.hideFindText();
        view.showProgressBar();
        searchInteractor.remoteFetch(this, query);
    }

    @Override
    public void onSuccess(List<Product> products) {
        view.hideProgressBar();
        if (products.size() > 0) {
            view.showSearch();
            view.showSearchList(products);
        } else {
            view.showNoResultItems();
        }

    }

    @Override
    public void onFailure() {
        view.showFindText();
        view.showDataFetchErrors();
        view.hideProgressBar();
        view.hideSearch();
    }

}

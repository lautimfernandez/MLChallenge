package com.example.mlchallenge.Interface;

import com.example.mlchallenge.Model.Product;

import java.util.List;

public interface SearchView  {
    void showProgressBar();

    void hideProgressBar();

    void showSearch();

    void hideSearch();

    void showSearchList(List<Product> products);

    void fetchSearchList(String query);

    void showDataFetchErrors();

}

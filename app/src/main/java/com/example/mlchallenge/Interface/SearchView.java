package com.example.mlchallenge.Interface;

import com.example.mlchallenge.Model.Product;

import java.util.List;

public interface SearchView {

    /**
     * This method set the loading progress bar visible
     */
    void showProgressBar();

    /**
     * This method set the loading progress bar gone
     */
    void hideProgressBar();

    /**
     * This method set the product's recycler view visible
     */
    void showSearch();

    /**
     * This method set the product's recycler view gone
     */
    void hideSearch();

    /**
     * This method set the products fetched to the recycler view
     * @param products the list of items
     */
    void showSearchList(List<Product> products);

    /**
     * This method calls the presenter to fetch the products list
     * @param query the product searched by the user
     */
    void fetchSearchList(String query);

    /**
     * This method show a error snackbar
     */
    void showDataFetchErrors();

    /**
     * This method set the result's text gone
     */
    void hideFindText();

    /**
     * This method set the result's text visible
     */
    void showFindText();

    /**
     * This method set the result's text with no results message
     */
    void showNoResultItems();
}

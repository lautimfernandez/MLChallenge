package com.example.mlchallenge.Presenter;

import com.example.mlchallenge.Interactor.SearchInteractor;
import com.example.mlchallenge.Interface.SearchView;
import com.example.mlchallenge.Model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class SearchPresenterTest {

    private static final String QUERY_TEST = "prueba";
    private SearchInteractor mockedSearchInteractor;
    private SearchView mockedView;
    private SearchPresenter searchPresenter;

    @Before
    public void setUp() {
        mockedSearchInteractor = Mockito.mock(SearchInteractor.class);
        mockedView = Mockito.mock(SearchView.class);
        searchPresenter = Mockito.spy(new SearchPresenter(mockedView, mockedSearchInteractor));
    }

    @Test
    public void fetchData_callsInteractor() {
        doNothing().when(mockedView).hideFindText();
        doNothing().when(mockedView).showProgressBar();
        doNothing().when(mockedSearchInteractor).remoteFetch(searchPresenter, QUERY_TEST);

        searchPresenter.fetchData(QUERY_TEST);

        verify(mockedSearchInteractor).remoteFetch(searchPresenter, QUERY_TEST);
    }

    @Test
    public void onSuccess_listWithElements() {
        final List<Product> productList = new ArrayList<>();
        productList.add(Mockito.mock(Product.class));

        doNothing().when(mockedView).hideProgressBar();
        doNothing().when(mockedView).showSearch();
        doNothing().when(mockedView).showSearchList(productList);

        searchPresenter.onSuccess(productList);

        verify(mockedView).showSearchList(productList);
        verify(mockedView).showSearch();
    }

    @Test
    public void onSuccess_listWithoutElements() {
        final List<Product> productList = new ArrayList<>();

        doNothing().when(mockedView).hideProgressBar();
        doNothing().when(mockedView).showNoResultItems();

        searchPresenter.onSuccess(productList);

        verify(mockedView).showNoResultItems();
    }


    @Test
    public void onFailure() {

        doNothing().when(mockedView).showFindText();
        doNothing().when(mockedView).showDataFetchErrors();
        doNothing().when(mockedView).hideProgressBar();
        doNothing().when(mockedView).hideSearch();

        searchPresenter.onFailure();

        verify(mockedView).showFindText();
        verify(mockedView).showDataFetchErrors();
        verify(mockedView).hideProgressBar();
        verify(mockedView).hideSearch();
    }
}
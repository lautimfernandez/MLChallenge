package com.example.mlchallenge.Interactor;

import com.example.mlchallenge.Model.Results;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import retrofit2.Call;

import static org.mockito.Mockito.mock;

public class GetResultsCallbackTest {

    private GetResultsCallback mockedGetResultsCallback;
    private SearchInteractor.OnSearchFetched listener;
    private Call<Results> mockedCall;

    @Before
    public void setUp() {
        listener = mock(SearchInteractor.OnSearchFetched.class);
        mockedGetResultsCallback = Mockito.spy(new GetResultsCallback(listener));
        mockedCall = mock(Call.class);
    }

    @Test
    public void getResultsCallback_onFailure() {
        mockedGetResultsCallback.onFailure(mockedCall, mock(Throwable.class));
        Mockito.verify(listener).onFailure();
    }
}
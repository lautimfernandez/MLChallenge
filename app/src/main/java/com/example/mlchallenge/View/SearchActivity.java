package com.example.mlchallenge.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mlchallenge.Adapter.RecyclerAdapter;
import com.example.mlchallenge.Base.BaseActivity;
import com.example.mlchallenge.Interface.SearchView;
import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.Interactor.SearchInteractor;
import com.example.mlchallenge.Presenter.SearchPresenter;
import com.example.mlchallenge.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView, android.widget.SearchView.OnQueryTextListener, RecyclerAdapter.ItemCLick {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerResults)
    @Nullable
    RecyclerView recyclerView;
    @BindView(R.id.findText)
    TextView findText;

    RecyclerAdapter adapter;

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @NonNull
    @Override
    protected SearchPresenter createPresenter(@NonNull Context context) {
        return new SearchPresenter(this, new SearchInteractor());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setTitle(R.string.hint_search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        android.widget.SearchView searchView = (android.widget.SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Buscá un producto");
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSearch() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSearch() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showSearchList(List<Product> products) {
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager linear = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);
        adapter = new RecyclerAdapter(products, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fetchSearchList(String value) {
        mPresenter.fetchData(value);
    }

    @Override
    public void showDataFetchErrors() {
        Snackbar.make(findViewById(android.R.id.content), "Ocurrió un error. Intentalo nuevamente.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideHintText() {
        findText.setVisibility(View.GONE);
    }

    @Override
    public void showHintText() {
        findText.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoResultItems() {
        showHintText();
        findText.setText("No se obtuvieron resultados para tu búsqueda.");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (this.isNetworkConnected()) {
            fetchSearchList(query);
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Sin conexion. Revise sus ajustes.", Snackbar.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onItemClick(Product product) {
        Intent resultsIntent = new Intent(SearchActivity.this, DetailsActivity.class);
        resultsIntent.putExtra("product", product);
        startActivity(resultsIntent);
    }
}

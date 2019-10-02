package com.example.mlchallenge.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mlchallenge.APIHolder.APIHolder;
import com.example.mlchallenge.Adapter.RecyclerAdapter;
import com.example.mlchallenge.Model.Results;
import com.example.mlchallenge.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class results extends AppCompatActivity implements RecyclerAdapter.ItemCLick {
    private RecyclerView resultsView;
    private Results res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String value = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("search");
        }

        getResults(value);

        resultsView = findViewById(R.id.recyclerResults);
        resultsView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        LinearLayoutManager linear = new LinearLayoutManager(this);
        resultsView.setLayoutManager(linear);

        RecyclerAdapter adapter = new RecyclerAdapter(res, this);

        resultsView.setAdapter(adapter);


    }

    private void getResults(String value) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIHolder holder = retrofit.create(APIHolder.class);

        Call<Results> call = holder.getResults(value);


        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                res = response.body();
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
    }


    @Override
    public void onItemClick(int clickedItem) {
        Intent productIntent = new Intent(results.this, product.class);
        productIntent.putExtra("item_id", clickedItem);
        startActivity(productIntent);

    }
}

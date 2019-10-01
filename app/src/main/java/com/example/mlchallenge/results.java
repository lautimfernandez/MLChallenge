package com.example.mlchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.mlchallenge.APIHolder.APIHolder;
import com.example.mlchallenge.Adapter.RecyclerAdapter;
import com.example.mlchallenge.Model.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class results extends AppCompatActivity implements RecyclerAdapter.ItemCLick {
    private RecyclerView resultsView;
    private List<Results> listResponse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String value="";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("search");
        }

        getResults();

        resultsView = findViewById(R.id.recyclerResults);
        resultsView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        LinearLayoutManager linear = new LinearLayoutManager(this);
        resultsView.setLayoutManager(linear);

        RecyclerAdapter adapter = new RecyclerAdapter(listResponse, this);

        resultsView.setAdapter(adapter);





    }

    private void getResults(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIHolder holder = retrofit.create(APIHolder.class);

        Call<List<Results>> call = holder.getResults();

        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                listResponse = response.body();


            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onItemClick(int clickedItem) {
        Intent productIntent = new Intent(results.this, product.class);
        productIntent.putExtra("item_id",clickedItem);
        startActivity(productIntent);

    }
}

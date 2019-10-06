package com.example.mlchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mlchallenge.View.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.mercadoLibre)
    ImageView mercadoLibre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        mercadoLibre.setOnClickListener(v -> {
            Intent searchIntent = new Intent(StartActivity.this, SearchActivity.class);
            startActivity(searchIntent);
        });



    }
}

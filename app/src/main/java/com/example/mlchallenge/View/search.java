package com.example.mlchallenge.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import com.example.mlchallenge.R;


public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton =  findViewById(R.id.searchButton);
        final EditText productText =  findViewById(R.id.productText);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultsIntent = new Intent(search.this, results.class);
                resultsIntent.putExtra("search",productText.getText().toString());
                startActivity(resultsIntent);
            }
        });


    }





}
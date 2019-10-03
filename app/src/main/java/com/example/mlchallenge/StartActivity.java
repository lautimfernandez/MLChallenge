package com.example.mlchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mlchallenge.View.SearchActivity;
import com.example.mlchallenge.View.results;
import com.example.mlchallenge.View.search;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button start = findViewById(R.id.startButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(StartActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });

    }
}

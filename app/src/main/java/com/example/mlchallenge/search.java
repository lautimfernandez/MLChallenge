package com.example.mlchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;




public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton =  findViewById(R.id.searchButton);
        EditText productText =  findViewById(R.id.productText);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultActivity();
            }
        });

    }

    private void resultActivity() {

        Intent resultsIntent = new Intent(this, results.class);

        startActivity(resultsIntent);

    }


}
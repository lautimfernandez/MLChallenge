package com.example.mlchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String value="";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("search");
        }

        TextView txt = findViewById(R.id.textView3);

        txt.setText(value);
    }
}

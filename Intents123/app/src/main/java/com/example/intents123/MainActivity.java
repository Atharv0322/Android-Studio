package com.example.intents123;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java file with activity_main.xml
        setContentView(R.layout.activity_main);

        // Connect Button with XML
        btnNext = findViewById(R.id.btnNext);

        // Perform action when button is clicked
        btnNext.setOnClickListener(v -> {

            // Create Explicit Intent
            // MainActivity = current page
            // SecondActivity = page we want to open
            Intent intent =
                    new Intent(MainActivity.this, SecondActivity.class);

            // Start SecondActivity
            startActivity(intent);
        });
    }
}
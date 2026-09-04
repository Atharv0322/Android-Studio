package com.example.practical3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        txtMessage = findViewById(R.id.txtMessage);

        btnShow.setOnClickListener(view -> {
            txtMessage.setText(R.string.welcome_message);
            txtMessage.setTextColor(ContextCompat.getColor(this, R.color.blue));
        });
    }
}
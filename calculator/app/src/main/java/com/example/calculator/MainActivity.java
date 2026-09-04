package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




    public class MainActivity extends AppCompatActivity {

        EditText e1, e2;
        Button b1;
        TextView t1;

        @SuppressLint("StringFormatInvalid")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            e1 = findViewById(R.id.editTextNumber);
            e2 = findViewById(R.id.editTextNumber2);
            b1 = findViewById(R.id.button);
            t1 = findViewById(R.id.textView2);

            b1.setOnClickListener(this::onClick);
        }

        private void onClick(View v) {
            int num1 = Integer.parseInt(e1.getText().toString());
            int num2 = Integer.parseInt(e2.getText().toString());

            int sum = num1 + num2;

            // t1.setText("Result = " + sum);

            t1.setText(getString(R.string.result, sum));
        }
    }


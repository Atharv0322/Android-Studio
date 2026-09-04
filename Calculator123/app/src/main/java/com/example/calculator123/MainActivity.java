package com.example.calculatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML views
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> calculate('+'));

        btnSubtract.setOnClickListener(v -> calculate('-'));

        btnMultiply.setOnClickListener(v -> calculate('*'));

        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operation) {

        String first = etNumber1.getText().toString().trim();
        String second = etNumber2.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(first);
        double num2 = Double.parseDouble(second);
        double result = 0;

        switch (operation) {

            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    tvResult.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                break;
        }

        tvResult.setText("Result: " + result);
    }
}
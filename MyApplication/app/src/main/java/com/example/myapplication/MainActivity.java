package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    TextView result;

    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnPercent, btnSquare, btnSqrt;
    Button btnMax, btnMin, btnAvg;
    Button btnClear, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextNumber1);
        e2 = findViewById(R.id.editTextNumber2);

        result = findViewById(R.id.txtResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnPercent = findViewById(R.id.btnPercent);
        btnSquare = findViewById(R.id.btnSquare);
        btnSqrt = findViewById(R.id.btnSqrt);

        btnMax = findViewById(R.id.btnMax);
        btnMin = findViewById(R.id.btnMin);
        btnAvg = findViewById(R.id.btnAvg);

        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);

        // Basic Operations
        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));

        // Percentage
        btnPercent.setOnClickListener(v -> {

            if (!checkInput()) return;

            double n1 = Double.parseDouble(e1.getText().toString());
            double n2 = Double.parseDouble(e2.getText().toString());

            double ans = (n1 * n2) / 100;

            result.setText("Result = " + ans);
        });

        // Square
        btnSquare.setOnClickListener(v -> {

            if (e1.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter First Number", Toast.LENGTH_SHORT).show();
                return;
            }

            double n = Double.parseDouble(e1.getText().toString());

            result.setText("Result = " + (n * n));
        });

        // Square Root
        btnSqrt.setOnClickListener(v -> {

            if (e1.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter First Number", Toast.LENGTH_SHORT).show();
                return;
            }

            double n = Double.parseDouble(e1.getText().toString());

            if (n < 0) {
                Toast.makeText(this, "Invalid Number", Toast.LENGTH_SHORT).show();
                return;
            }

            result.setText("Result = " + Math.sqrt(n));
        });

        // Maximum
        btnMax.setOnClickListener(v -> {

            if (!checkInput()) return;

            double n1 = Double.parseDouble(e1.getText().toString());
            double n2 = Double.parseDouble(e2.getText().toString());

            result.setText("Maximum = " + Math.max(n1, n2));
        });

        // Minimum
        btnMin.setOnClickListener(v -> {

            if (!checkInput()) return;

            double n1 = Double.parseDouble(e1.getText().toString());
            double n2 = Double.parseDouble(e2.getText().toString());

            result.setText("Minimum = " + Math.min(n1, n2));
        });

        // Average
        btnAvg.setOnClickListener(v -> {

            if (!checkInput()) return;

            double n1 = Double.parseDouble(e1.getText().toString());
            double n2 = Double.parseDouble(e2.getText().toString());

            result.setText("Average = " + ((n1 + n2) / 2));
        });

        // Clear
        btnClear.setOnClickListener(v -> {

            e1.setText("");
            e2.setText("");

            result.setText("Result = 0");
        });

        // Exit
        btnExit.setOnClickListener(v -> finish());
    }

    // Basic Calculator
    private void calculate(char op) {

        if (!checkInput()) return;

        double n1 = Double.parseDouble(e1.getText().toString());
        double n2 = Double.parseDouble(e2.getText().toString());

        double ans = 0;

        switch (op) {

            case '+':
                ans = n1 + n2;
                break;

            case '-':
                ans = n1 - n2;
                break;

            case '*':
                ans = n1 * n2;
                break;

            case '/':

                if (n2 == 0) {
                    Toast.makeText(this, "Cannot Divide By Zero", Toast.LENGTH_SHORT).show();
                    return;
                }

                ans = n1 / n2;
                break;
        }

        result.setText("Result = " + ans);
    }

    // Input Validation
    private boolean checkInput() {

        if (e1.getText().toString().trim().isEmpty()
                || e2.getText().toString().trim().isEmpty()) {

            Toast.makeText(this,
                    "Please Enter Both Numbers",
                    Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }
}
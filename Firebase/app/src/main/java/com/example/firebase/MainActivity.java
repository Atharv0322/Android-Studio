package com.example.firebase;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName, etEmail, etPhone;
    Button btnAdd, btnView, btnUpdate, btnDelete;
    TextView tvResult;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML components
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        tvResult = findViewById(R.id.tvResult);

        // Create database object
        databaseHelper = new DatabaseHelper(this);


        // ================= CREATE =================

        btnAdd.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {

                Toast.makeText(this,
                        "Please enter all details",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            boolean result = databaseHelper.insertStudent(
                    name,
                    email,
                    phone
            );

            if (result) {

                Toast.makeText(this,
                        "Student Added Successfully",
                        Toast.LENGTH_SHORT).show();

                clearFields();

            } else {

                Toast.makeText(this,
                        "Failed to Add Student",
                        Toast.LENGTH_SHORT).show();
            }
        });


        // ================= READ =================

        btnView.setOnClickListener(v -> {

            Cursor cursor = databaseHelper.getAllStudents();

            if (cursor.getCount() == 0) {

                tvResult.setText("No Students Found");

                cursor.close();
                return;
            }

            StringBuilder data = new StringBuilder();

            while (cursor.moveToNext()) {

                data.append("ID: ")
                        .append(cursor.getString(0))
                        .append("\n");

                data.append("Name: ")
                        .append(cursor.getString(1))
                        .append("\n");

                data.append("Email: ")
                        .append(cursor.getString(2))
                        .append("\n");

                data.append("Phone: ")
                        .append(cursor.getString(3))
                        .append("\n");

                data.append("------------------------\n");
            }

            cursor.close();

            tvResult.setText(data.toString());
        });


        // ================= UPDATE =================

        btnUpdate.setOnClickListener(v -> {

            String id = etId.getText().toString().trim();
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            if (id.isEmpty()) {

                Toast.makeText(this,
                        "Enter Student ID",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            boolean result = databaseHelper.updateStudent(
                    id,
                    name,
                    email,
                    phone
            );

            if (result) {

                Toast.makeText(this,
                        "Student Updated Successfully",
                        Toast.LENGTH_SHORT).show();

                clearFields();

            } else {

                Toast.makeText(this,
                        "Student Not Found",
                        Toast.LENGTH_SHORT).show();
            }
        });


        // ================= DELETE =================

        btnDelete.setOnClickListener(v -> {

            String id = etId.getText().toString().trim();

            if (id.isEmpty()) {

                Toast.makeText(this,
                        "Enter Student ID",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            boolean result = databaseHelper.deleteStudent(id);

            if (result) {

                Toast.makeText(this,
                        "Student Deleted Successfully",
                        Toast.LENGTH_SHORT).show();

                clearFields();

            } else {

                Toast.makeText(this,
                        "Student Not Found",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Clear input fields
    private void clearFields() {

        etId.setText("");
        etName.setText("");
        etEmail.setText("");
        etPhone.setText("");
    }
}
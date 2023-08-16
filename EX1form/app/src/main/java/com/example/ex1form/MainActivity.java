package com.example.ex1form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextStudentID, editTextCollege, editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextCollege = findViewById(R.id.editTextCollege);
        editTextAddress = findViewById(R.id.editTextAddress);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        Button buttonReset = findViewById(R.id.buttonReset);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String studentID = editTextStudentID.getText().toString();
                String college = editTextCollege.getText().toString();
                String address = editTextAddress.getText().toString();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("name", name);
                intent.putExtra("studentID", studentID);
                intent.putExtra("college", college);
                intent.putExtra("address", address);
                startActivity(intent);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setText("");
                editTextStudentID.setText("");
                editTextCollege.setText("");
                editTextAddress.setText("");
            }
        });
    }
}
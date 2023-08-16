package com.example.ex1form;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textViewResult = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String studentID = intent.getStringExtra("studentID");
        String college = intent.getStringExtra("college");
        String address = intent.getStringExtra("address");

        String result = "Name: " + name + "\nStudent ID: " + studentID + "\nCollege: " + college + "\nAddress: " + address;
        textViewResult.setText(result);
    }
}





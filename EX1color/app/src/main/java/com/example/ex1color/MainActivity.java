package com.example.ex1color;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        textView = findViewById(R.id.textView);
    }

    public void changeColorRed(View view) {
        mainLayout.setBackgroundColor(Color.RED);
    }

    public void changeColorBlue(View view) {
        mainLayout.setBackgroundColor(Color.BLUE);
    }

    public void changeColorGreen(View view) {
        mainLayout.setBackgroundColor(Color.GREEN);
    }

    public void changeColorYellow(View view) {
        mainLayout.setBackgroundColor(Color.YELLOW);
    }

    public void changeTextColor(View view) {
        Random random = new Random();
        int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        textView.setTextColor(color);
    }
}

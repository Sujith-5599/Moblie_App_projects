package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText, number2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onCalculateClick(View view) {
        double number1 = Double.parseDouble(number1EditText.getText().toString());
        double number2 = Double.parseDouble(number2EditText.getText().toString());

        double result = 0;

        switch (view.getId()) {
            case R.id.btnAdd:
                result = number1 + number2;
                break;
            case R.id.btnSubtract:
                result = number1 - number2;
                break;
            case R.id.btnMultiply:
                result = number1 * number2;
                break;
            case R.id.btnDivide:
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    resultTextView.setText("Error: Division by zero");
                    return;
                }
                break;
        }

        resultTextView.setText("Result: " + result);
    }
}
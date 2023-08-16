package com.example.ex1calculator;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText firstInputEditText;
    private EditText secondInputEditText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstInputEditText = findViewById(R.id.firstInputEditText);
        secondInputEditText = findViewById(R.id.secondInputEditText);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        resultTextView = findViewById(R.id.resultTextView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operator) {
        String firstValueStr = firstInputEditText.getText().toString();
        String secondValueStr = secondInputEditText.getText().toString();

        try {
            if (operator == '+') {
                String result = firstValueStr + secondValueStr;
                resultTextView.setText("Result: " + result);
            } else {
                double firstValue = Double.parseDouble(firstValueStr);
                double secondValue = Double.parseDouble(secondValueStr);
                double result = 0;

                switch (operator) {
                    case '-':
                        result = firstValue - secondValue;
                        break;
                    case '*':
                        result = firstValue * secondValue;
                        break;
                    case '/':
                        if (secondValue == 0) {
                            resultTextView.setText("Cannot divide by zero.");
                            return;
                        }
                        result = firstValue / secondValue;
                        break;
                }

                resultTextView.setText("Result: " + String.valueOf(result));
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter valid numbers.");
        }
    }
}


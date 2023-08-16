package com.example.ex3excell;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; // Import HSSFWorkbook
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private TextView excelContentTextView;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        excelContentTextView = findViewById(R.id.excelContentTextView);
        Button readButton = findViewById(R.id.readButton);
        exitButton = findViewById(R.id.exitButton);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    readExcelFileFromAssets();
                } catch (IOException e) {
                    e.printStackTrace();
                    excelContentTextView.setText("Error reading Excel file");
                }
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void readExcelFileFromAssets() throws IOException {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open("book.xls"); // Change to the correct filename

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream); // Use HSSFWorkbook
        Sheet sheet = workbook.getSheetAt(0);

        StringBuilder excelData = new StringBuilder();

        for (Row row : sheet) {
            for (Cell cell : row) {
                excelData.append(cell.toString()).append("\t");
            }
            excelData.append("\n");
        }

        workbook.close();
        inputStream.close();

        excelContentTextView.setText(excelData.toString());
    }
}
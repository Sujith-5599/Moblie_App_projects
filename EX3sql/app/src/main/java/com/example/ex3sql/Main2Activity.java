package com.example.ex3sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class Main2Activity extends AppCompatActivity {

    Button back, next, prev;
    TextView fn, ln;
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        back = findViewById(R.id.buttonBack);
        next = findViewById(R.id.buttonNext);
        prev = findViewById(R.id.buttonPrev);
        fn = findViewById(R.id.textViewName);
        ln = findViewById(R.id.textViewCode);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        c = db.rawQuery("SELECT * FROM course", null);
        c.moveToFirst();

        showData();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.moveToNext()) {
                    showData();
                } else {
                    Toast.makeText(getApplicationContext(), "Last Record", Toast.LENGTH_LONG).show();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.moveToPrevious()) {
                    showData();
                } else {
                    Toast.makeText(getApplicationContext(), "First Record", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void showData() {
        String name = c.getString(c.getColumnIndex("name"));
        String code = c.getString(c.getColumnIndex("code"));
        fn.setText(name);
        ln.setText(code);
    }
}

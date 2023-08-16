package com.example.ex2font;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        txt = findViewById(R.id.tv);

        String[] values = new String[]{"AAAAAAAA", "BBBBBBB", "CCCCCCC", "DDDDDD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                txt.setText(itemValue);

                String fontPath;
                switch (itemValue) {
                    case "AAAAAAAA":
                        fontPath = "fonts/corbel.ttf";
                        break;
                    case "BBBBBBB":
                        fontPath = "fonts/framd.ttf";
                        break;
                    case "CCCCCCC":
                        fontPath = "fonts/Gabriola.ttf";
                        break;
                    case "DDDDDD":
                        fontPath = "fonts/cour.ttf";
                        break;
                    default:
                        fontPath = "fonts/default_font.ttf";
                        break;
                }

                try {
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

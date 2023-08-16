package com.example.ex2menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        exitButton = findViewById(R.id.exit_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(MainActivity.this, b1);
                pm.getMenuInflater().inflate(R.menu.menu, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.one) {
                            Intent o = new Intent(getApplicationContext(), Second.class);
                            startActivity(o);
                            return true;
                        } else if (item.getItemId() == R.id.two) {
                            Intent in = new Intent(getApplicationContext(), Third.class);
                            startActivity(in);
                            return true;
                        }
                        else if (item.getItemId() == R.id.three) {
                            Intent in = new Intent(getApplicationContext(), fourth.class);
                            startActivity(in);
                            return true;
                        }

                        else if (item.getItemId() == R.id.four) {
                            Intent in = new Intent(getApplicationContext(), fifth.class);
                            startActivity(in);
                            return true;
                            }

                        return false;
                    }
                });
                pm.show();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // This will close the entire app including all activities.
            }
        });
    }
}

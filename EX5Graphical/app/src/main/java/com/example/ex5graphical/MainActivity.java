package com.example.ex5graphical;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DemoView dv = new DemoView(this);
        setContentView(dv);
    }

    private class DemoView extends View {
        public DemoView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Set background color
            canvas.drawColor(Color.WHITE);

            Paint ob = new Paint();
            ob.setStyle(Paint.Style.FILL);

            ob.setColor(Color.GRAY);
            canvas.drawCircle(100, 100, 60, ob);

            ob.setColor(Color.CYAN);
            canvas.drawCircle(200, 50, 30, ob);

            ob.setColor(Color.MAGENTA);
            canvas.drawRect(200, 200, 400, 400, ob);

            ob.setColor(Color.RED);
            canvas.drawLine(250, 50, 350, 400, ob);

            canvas.rotate(-45);

            // Remember to close the onDraw method
        }
    }
}

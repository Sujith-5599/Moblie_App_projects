package com.example.ex3sdcard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
public class MainActivity extends AppCompatActivity {
    EditText fname;
    EditText data;
    String fn, dat;
    Button sa,re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname=(EditText) findViewById(R.id.fnamee);
        data=(EditText) findViewById(R.id.datae);
        sa=(Button) findViewById(R.id.save);
        re=(Button) findViewById(R.id.read);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn=fname.getText().toString();
                dat=data.getText().toString();
                try{
                    File myfile;
                    myfile=new File(getExternalFilesDir("sdcard"),fn);
                    myfile.createNewFile();
                    FileOutputStream fout=new FileOutputStream(myfile);
                    OutputStreamWriter myoutWriter=new OutputStreamWriter(fout);
                    myoutWriter.append(dat);
                    myoutWriter.close();
                    Toast.makeText(getApplicationContext(),"File Saved",Toast.LENGTH_LONG).show();
                }
                catch(FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch(IOException i)
                {
                    i.printStackTrace();
                }
            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aDataRow;
                String aBuffer="";
                try
                {
                    fn=fname.getText().toString();
                    File myFile=new File(getExternalFilesDir("sdcard"),fn);
                    FileInputStream fin=new FileInputStream(myFile);
                    BufferedReader myReadear=new BufferedReader(new InputStreamReader(fin));
                    while ((aDataRow=myReadear.readLine())!=null)
                    {
                        aBuffer+=aDataRow+"\n";
                    }
                    System.out.println(aBuffer);
                    myReadear.close();
                }
                catch (IOException e)
                { }
                Toast.makeText(getApplicationContext(),aBuffer,Toast.LENGTH_LONG).show();
            }
        });
    }
}
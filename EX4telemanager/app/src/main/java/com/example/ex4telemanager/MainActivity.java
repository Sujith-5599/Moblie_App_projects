package com.example.ex4telemanager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private TextView tv;
    private TelephonyManager telephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            displayTelephonyInfo();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);
        }
    }

    private void displayTelephonyInfo() {
        String nwcountryISO = telephonyManager.getNetworkCountryIso();
        String SIMCountryISO = telephonyManager.getSimCountryIso();
        String PhoneType = "";
        int phoneType = telephonyManager.getPhoneType();
        switch (phoneType) {
            case TelephonyManager.PHONE_TYPE_CDMA:
                PhoneType = "CDMA";
                break;
            case TelephonyManager.PHONE_TYPE_GSM:
                PhoneType = "GSM";
                break;
            case TelephonyManager.PHONE_TYPE_NONE:
                PhoneType = "NONE";
                break;
        }
        boolean checkRoaming = telephonyManager.isNetworkRoaming();
        String data = "Your Mobile Details are enlisted below: \n";
        data += "\n Network Country ISO is - " + nwcountryISO;
        data += "\n SIM Country ISO is - " + SIMCountryISO;
        data += "\n Network type is - " + PhoneType;
        data += "\n Roaming on is - " + checkRoaming;
        tv.setText(data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                displayTelephonyInfo();
            } else {
                tv.setText("Permission denied. Cannot access telephony information.");
            }
        }
    }
}

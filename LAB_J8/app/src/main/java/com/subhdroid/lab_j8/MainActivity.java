package com.subhdroid.lab_j8;

//8. Write an android code to turn ON /OFF the Wi-Fi

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppCompatButton onBtn, offBtn;

        onBtn = findViewById(R.id.onBtn);
        offBtn = findViewById(R.id.offBtn);

        WifiManager wifiManager =
                (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        onBtn.setOnClickListener(view -> {
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
        });

        offBtn.setOnClickListener(view -> {
            if (wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
            }
        });
    }
}
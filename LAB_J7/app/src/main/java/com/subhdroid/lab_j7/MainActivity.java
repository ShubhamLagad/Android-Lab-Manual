package com.subhdroid.lab_j7;

//7. Write an android code to turn ON/OFF Bluetooth

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton onBtn, offBtn;

        onBtn = findViewById(R.id.onBtn);
        offBtn = findViewById(R.id.offBtn);

        final BluetoothAdapter bluetAdapter = BluetoothAdapter.getDefaultAdapter();

        onBtn.setOnClickListener(view -> {
            if (!bluetAdapter.isEnabled()) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    bluetAdapter.enable();
                }
            }
        });

        offBtn.setOnClickListener(view -> {
            if (bluetAdapter.isEnabled()) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    bluetAdapter.disable();
                }
            }
        });
    }
}
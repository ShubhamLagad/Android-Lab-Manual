package com.subhdroid.lab_j6;

//6. Write an android code to make phone call using Intent

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mobNo = findViewById(R.id.mobNo);
        AppCompatButton callBtn = findViewById(R.id.callBtn);

        callBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + mobNo.getText().toString()));
            startActivity(intent);
        });
    }
}
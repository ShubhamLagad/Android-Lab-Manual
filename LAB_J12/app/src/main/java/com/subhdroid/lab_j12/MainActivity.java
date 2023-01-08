package com.subhdroid.lab_j12;

//12. Write an application to demonstrate Alert Dialog Box in android

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
        alertBox.setTitle("Exit");
        alertBox.setMessage("Are you sure want to exit?");
        alertBox.setPositiveButton("Yes", (dialogInterface, i) -> finishAffinity());
        alertBox.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss());
        alertBox.show();
    }
}
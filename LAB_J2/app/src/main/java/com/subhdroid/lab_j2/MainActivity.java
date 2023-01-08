package com.subhdroid.lab_j2;

//2. Design an android application by using RadioGroup and RadioButton to display list of PG
//        courses names. Display selected PG course name by the user using Toast


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void radioBtnClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.mca:
                Toast.makeText(this, "MCA Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mba:
                Toast.makeText(this, "MBA Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mteck:
                Toast.makeText(this, "MTech Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mcom:
                Toast.makeText(this, "MCom Selected", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
package com.subhdroid.lab_j5;

//5. Design an android application by using Spinner component to display secondary colors names.
//        As per user selected a color from Spinner component, change the activity background color.

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        LinearLayout ll = findViewById(R.id.ll);

        String color[] = {"Purple", "Teal", "Black", "White"};

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, color);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int id = view.getId();

                if (color[i] == "Purple") {
                    ll.setBackgroundColor(getResources().getColor(R.color.purple_200));
                }
                if (color[i] == "Teal") {
                    ll.setBackgroundColor(getResources().getColor(R.color.teal_200));
                }
                if (color[i] == "Black") {
                    ll.setBackgroundColor(getResources().getColor(R.color.black));
                }
                if (color[i] == "White") {
                    ll.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
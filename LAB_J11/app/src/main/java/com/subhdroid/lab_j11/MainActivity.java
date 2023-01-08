package com.subhdroid.lab_j11;

//11. Demonstrate Array Adapter using List View to display list of fruits.

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lstView = findViewById(R.id.lstView);

        String fruits[] = {"Apple","Banana","Orange","Mango","Dragan"};

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,fruits);

        lstView.setAdapter(adapter);


    }
}
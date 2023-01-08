package com.subhdroid.lab_j4;

//4. Design an android application to design image gallery by using ImageButton and GridLayout.
//        As per the ImageButton click, display the image properties using Toast definition.

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton first, second, third, forth, fifth, sixth;

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        forth = findViewById(R.id.forth);

        first.setOnClickListener(V -> {

            Toast.makeText(this, "first Image clicked \n" + "image id:" + first.getId(), Toast.LENGTH_SHORT).show();

        });
        second.setOnClickListener(V -> {

            Toast.makeText(this, "second Image clicked \n" + "image id:" + second.getId(), Toast.LENGTH_SHORT).show();

        });
        third.setOnClickListener(V -> {

            Toast.makeText(this, "third Image clicked \n" + "image id:" + third.getId(), Toast.LENGTH_SHORT).show();

        });
        forth.setOnClickListener(V -> {

            Toast.makeText(this, "fourth Image clicked \n" + "image id:" + forth.getId(),
                    Toast.LENGTH_SHORT).show();

        });

    }
}
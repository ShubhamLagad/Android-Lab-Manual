package com.subhdroid.lab_j1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox red,white,green,yellow;
    TextView colorTxt;
    AppCompatButton displayBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.red);
        white = findViewById(R.id.white);
        green = findViewById(R.id.green);
        yellow = findViewById(R.id.yellow);
        colorTxt = findViewById(R.id.colorTxt);
        displayBtn = findViewById(R.id.displayBtn);

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt="";
                if (red.isChecked()){
                    txt+="\n"+red.getText().toString();
                }
                if (white.isChecked()){
                    txt+="\n"+white.getText().toString();
                }
                if (green.isChecked()){
                    txt+="\n"+green.getText().toString();
                }
                if (yellow.isChecked()){
                    txt+="\n"+yellow.getText().toString();
                }

                colorTxt.setText(txt);
            }
        });




    }
}
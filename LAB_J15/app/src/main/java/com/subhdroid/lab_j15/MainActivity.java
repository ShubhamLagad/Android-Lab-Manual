package com.subhdroid.lab_j15;

//15. Write an android application using SQLite to create table and perform CRUD operations
//        (Example. COURSE table (ID, Name, Duration, Description), perform ADD, UPDATE,
//        DELETE and READ operations)

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBClass mydb = new MyDBClass(this);
        EditText name, duration, description;
        TextView txt = findViewById(R.id.txtView);
        name = findViewById(R.id.name);
        duration = findViewById(R.id.duration);
        description = findViewById(R.id.description);

        findViewById(R.id.addBtn).setOnClickListener(view -> mydb.addRecord(name.getText().toString(), duration.getText().toString(),
                description.getText().toString()));

        findViewById(R.id.updateBtn).setOnClickListener(view -> mydb.updateRecord(duration.getText().toString(),
                name.getText().toString()));

        findViewById(R.id.deleteBtn).setOnClickListener(view -> mydb.deleteRecord(name.getText().toString()));

        findViewById(R.id.displayBtn).setOnClickListener(view -> {
            ArrayList<CourseModel> list = mydb.getRecords();
            String str = "ID    Name    Duration    Description";

            for (int i = 0; i < list.size(); i++) {

                str += "\n" + list.get(i).id + "    " + list.get(i).name + "    " + list.get(i).duration + "    " + list.get(i).description;

            }

            txt.setText(str);
        });


    }
}
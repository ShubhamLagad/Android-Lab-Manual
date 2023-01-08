package com.subhdroid.lab_j16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    DatabaseReference courseRef = FirebaseDatabase.getInstance().getReference("course");
    EditText name, duration, description;
    TextView txt;
    String record = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt = findViewById(R.id.txtView);
        name = findViewById(R.id.name);
        duration = findViewById(R.id.duration);
        description = findViewById(R.id.description);

        findViewById(R.id.addBtn).setOnClickListener(view -> addRecord());

        findViewById(R.id.updateBtn).setOnClickListener(view -> updateRecord());

        findViewById(R.id.deleteBtn).setOnClickListener(view -> deleteRecord());

        findViewById(R.id.displayBtn).setOnClickListener(view -> {
            getAllCourse();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    txt.setText(record);
                }
            }, 3000);
        });

    }


    private void addRecord() {
        CourseModel courseModel = new CourseModel(name.getText().toString(),
                duration.getText().toString(),
                description.getText().toString());

        String courseID = courseRef.push().getKey();

        courseRef.child(courseID).setValue(courseModel);
        Toast.makeText(this, "Course added", Toast.LENGTH_SHORT).show();
    }

    private void deleteRecord() {
        courseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, Array> dataMap = (HashMap<String, Array>) dataSnapshot.getValue();
                for (String key : dataMap.keySet()) {
                    courseRef.child(key).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            CourseModel course = snapshot.getValue(CourseModel.class);

                            if (name.getText().toString().equals(course.getName())) {
                                snapshot.getRef().removeValue();
                                Toast.makeText(MainActivity.this, "Record deleted",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.d("DB Error : ", error.toString());
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateRecord() {
        courseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, Array> dataMap = (HashMap<String, Array>) dataSnapshot.getValue();
                for (String key : dataMap.keySet()) {
                    courseRef.child(key).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            CourseModel course = snapshot.getValue(CourseModel.class);
                            if (name.getText().toString().equals(course.getName())) {
                                courseRef.child(key).child("duration").setValue(duration.getText().toString());
                                Toast.makeText(MainActivity.this, "Record Updated",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.d("DB Error : ", error.toString());
                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getAllCourse() {
        courseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, Array> dataMap = (HashMap<String, Array>) dataSnapshot.getValue();
                record = "";
                for (String key : dataMap.keySet()) {
                    courseRef.child(key).addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            CourseModel course = snapshot.getValue(CourseModel.class);

                            String str = "\n" + course.getName() + "    " + course.getDuration() +
                                    "    " + course.getDescription();

                            record += str;

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.d("DB Error : ", error.toString());
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
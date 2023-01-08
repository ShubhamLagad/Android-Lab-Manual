package com.subhdroid.lab_j18;

//18. Write an android app to write JSON data into a file and read JSON data from created file.

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    AppCompatButton setDataBtn, getDataBtn;
    EditText name, mobile;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        data = findViewById(R.id.data);

        setDataBtn = findViewById(R.id.setDataBtn);
        getDataBtn = findViewById(R.id.getDataBtn);

        setDataBtn.setOnClickListener(view -> setData());

        getDataBtn.setOnClickListener(view -> getData());
    }

    private void setData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Name", name.getText().toString());
            jsonObject.put("Phone", mobile.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String userString = jsonObject.toString();
        try {
            File file = new File(getApplicationContext().getFilesDir(), "LAB_J18.json");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Data Set", Toast.LENGTH_SHORT).show();
    }

    private void getData() {
        try {
            File file = new File(getApplicationContext().getFilesDir(), "LAB_J18.json");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            String response = stringBuilder.toString();
            JSONObject jsonObject = new JSONObject(response);
            String rec = "Name : " + jsonObject.get("Name");
            rec += "\nPhone : " + jsonObject.get("Phone");
            data.setText(rec);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
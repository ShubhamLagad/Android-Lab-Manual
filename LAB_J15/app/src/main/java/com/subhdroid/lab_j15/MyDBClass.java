package com.subhdroid.lab_j15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBClass extends SQLiteOpenHelper {
    private static final String DBName = "LabDB";
    private static final int DB_VERSION = 1;
    Context context;
    public MyDBClass(@Nullable Context context) {
        super(context, DBName, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE course(id INTEGER PRIMARY KEY AUTOINCREMENT,name " +
                "TEXT,duration TEXT,description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addRecord(String name, String duration, String description) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("duration", duration);
        values.put("description", description);

        database.insert("course", null, values);
        Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
//        database.close();
    }

    public ArrayList<CourseModel> getRecords() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM course", null);

        ArrayList<CourseModel> recordList = new ArrayList<>();

        while (cursor.moveToNext()) {

            CourseModel model = new CourseModel();

            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.duration = cursor.getString(2);
            model.description = cursor.getString(3);

            recordList.add(model);
        }
        return recordList;
    }


    public void updateRecord(String duration, String name) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("duration", duration);

        db.update("course", cv, "name=?", new String[]{name});
        Toast.makeText(context, "Updated successfully", Toast.LENGTH_SHORT).show();
    }


    public void deleteRecord(String courseName) {
        SQLiteDatabase database = this.getWritableDatabase();

        database.delete("course", "name=?", new String[]{courseName});
        Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();
    }
}

// Slip 24 - Q2: Car SQLite Database
// File: CarDBActivity.java

package com.example.cardb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

public class CarDBActivity extends Activity {

    SQLiteDatabase db;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);

        db = openOrCreateDatabase("CarDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Car " +
                "(id INTEGER PRIMARY KEY, name TEXT, type TEXT, color TEXT)");

        insertCars();
        showAllCars();
    }

    void insertCars() {
        db.execSQL("DELETE FROM Car");
        db.execSQL("INSERT INTO Car VALUES (1, 'Swift', 'Hatchback', 'Red')");
        db.execSQL("INSERT INTO Car VALUES (2, 'Innova', 'SUV', 'White')");
        db.execSQL("INSERT INTO Car VALUES (3, 'City', 'Sedan', 'Silver')");
        db.execSQL("INSERT INTO Car VALUES (4, 'Nexon', 'Compact SUV', 'Blue')");
        db.execSQL("INSERT INTO Car VALUES (5, 'Baleno', 'Hatchback', 'Grey')");
        Toast.makeText(this, "5 Cars Inserted!", Toast.LENGTH_SHORT).show();
    }

    void showAllCars() {
        Cursor cursor = db.rawQuery("SELECT * FROM Car", null);
        StringBuilder sb = new StringBuilder();
        sb.append("ID | Name | Type | Color\n");
        sb.append("----------------------------------\n");
        while (cursor.moveToNext()) {
            sb.append(cursor.getInt(0)).append(" | ")
              .append(cursor.getString(1)).append(" | ")
              .append(cursor.getString(2)).append(" | ")
              .append(cursor.getString(3)).append("\n");
        }
        cursor.close();
        tvResult.setText(sb.toString());
    }
}

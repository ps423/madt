// Slip 18 - Q2: Project SQLite Database
// File: ProjectDBActivity.java

package com.example.projectdb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

public class ProjectDBActivity extends Activity {

    SQLiteDatabase db;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);

        db = openOrCreateDatabase("ProjectDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Project " +
                "(id INTEGER PRIMARY KEY, name TEXT, dept TEXT, city TEXT)");

        insertProjects();
        showAllProjects();
    }

    void insertProjects() {
        db.execSQL("DELETE FROM Project");
        db.execSQL("INSERT INTO Project VALUES (1, 'Hospital Mgmt', 'CS', 'Pune')");
        db.execSQL("INSERT INTO Project VALUES (2, 'Banking System', 'IT', 'Mumbai')");
        db.execSQL("INSERT INTO Project VALUES (3, 'Library System', 'CS', 'Nashik')");
        db.execSQL("INSERT INTO Project VALUES (4, 'Inventory Control', 'Mech', 'Nagpur')");
        db.execSQL("INSERT INTO Project VALUES (5, 'E-Commerce App', 'IT', 'Bengaluru')");
        Toast.makeText(this, "5 Projects Inserted!", Toast.LENGTH_SHORT).show();
    }

    void showAllProjects() {
        Cursor cursor = db.rawQuery("SELECT * FROM Project", null);
        StringBuilder sb = new StringBuilder();
        sb.append("ID | Name | Dept | City\n");
        sb.append("----------------------------------------\n");
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

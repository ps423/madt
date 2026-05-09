// Slip 1 - Q2: SQLite Student Database
// File: MainActivity.java

package com.example.studentdb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    SQLiteDatabase db;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);

        // Create / Open Database
        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);

        // Create Table
        db.execSQL("CREATE TABLE IF NOT EXISTS Student " +
                "(roll_no INTEGER PRIMARY KEY, name TEXT, address TEXT, percentage REAL)");

        insertStudents();
        showAllStudents();
    }

    void insertStudents() {
        db.execSQL("DELETE FROM Student"); // Clear before inserting
        db.execSQL("INSERT INTO Student VALUES (1, 'Rahul Patil', 'Pune', 85.5)");
        db.execSQL("INSERT INTO Student VALUES (2, 'Priya Sharma', 'Mumbai', 90.0)");
        db.execSQL("INSERT INTO Student VALUES (3, 'Amit Desai', 'Nashik', 78.3)");
        db.execSQL("INSERT INTO Student VALUES (4, 'Sneha More', 'Kolhapur', 92.1)");
        db.execSQL("INSERT INTO Student VALUES (5, 'Vikas Jadhav', 'Aurangabad', 88.7)");
        Toast.makeText(this, "5 Students Inserted!", Toast.LENGTH_SHORT).show();
    }

    void showAllStudents() {
        Cursor cursor = db.rawQuery("SELECT * FROM Student", null);
        StringBuilder sb = new StringBuilder();
        sb.append("Roll No | Name | Address | Percentage\n");
        sb.append("----------------------------------------\n");
        while (cursor.moveToNext()) {
            sb.append(cursor.getInt(0)).append(" | ")
              .append(cursor.getString(1)).append(" | ")
              .append(cursor.getString(2)).append(" | ")
              .append(cursor.getFloat(3)).append("\n");
        }
        cursor.close();
        tvResult.setText(sb.toString());
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Student Database"
        android:textSize="20sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="14sp"
        android:fontFamily="monospace"/>

</LinearLayout>
*/

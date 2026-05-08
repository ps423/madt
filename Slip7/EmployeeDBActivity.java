// Slip 7 - Q2: Employee SQLite Database
// File: EmployeeDBActivity.java

package com.example.employeedb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDBActivity extends Activity {

    SQLiteDatabase db;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);

        db = openOrCreateDatabase("EmployeeDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Employee " +
                "(E_id INTEGER PRIMARY KEY, name TEXT, address TEXT, ph_no TEXT)");

        insertEmployees();
        showAllEmployees();
    }

    void insertEmployees() {
        db.execSQL("DELETE FROM Employee");
        db.execSQL("INSERT INTO Employee VALUES (101, 'Rajesh Kumar', 'Pune', '9876543210')");
        db.execSQL("INSERT INTO Employee VALUES (102, 'Sunita Sharma', 'Mumbai', '9823456789')");
        db.execSQL("INSERT INTO Employee VALUES (103, 'Amit Patil', 'Nashik', '9812345678')");
        db.execSQL("INSERT INTO Employee VALUES (104, 'Priya Desai', 'Nagpur', '9801234567')");
        db.execSQL("INSERT INTO Employee VALUES (105, 'Vikram More', 'Kolhapur', '9790123456')");
        Toast.makeText(this, "5 Employees Inserted!", Toast.LENGTH_SHORT).show();
    }

    void showAllEmployees() {
        Cursor cursor = db.rawQuery("SELECT * FROM Employee", null);
        StringBuilder sb = new StringBuilder();
        sb.append("EID | Name | Address | Phone\n");
        sb.append("--------------------------------------\n");
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

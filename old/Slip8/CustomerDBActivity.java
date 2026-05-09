// Slip 8 - Q2: Customer SQLite Database
// File: CustomerDBActivity.java

package com.example.customerdb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerDBActivity extends Activity {

    SQLiteDatabase db;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);

        db = openOrCreateDatabase("CustomerDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Customer " +
                "(id INTEGER PRIMARY KEY, name TEXT, address TEXT, ph_no TEXT)");

        insertCustomers();
        showAllCustomers();
    }

    void insertCustomers() {
        db.execSQL("DELETE FROM Customer");
        db.execSQL("INSERT INTO Customer VALUES (1, 'Arun Mehta', 'Delhi', '9988776655')");
        db.execSQL("INSERT INTO Customer VALUES (2, 'Meena Joshi', 'Jaipur', '9977665544')");
        db.execSQL("INSERT INTO Customer VALUES (3, 'Suresh Nair', 'Chennai', '9966554433')");
        db.execSQL("INSERT INTO Customer VALUES (4, 'Kavita Singh', 'Hyderabad', '9955443322')");
        db.execSQL("INSERT INTO Customer VALUES (5, 'Deepak Rao', 'Bengaluru', '9944332211')");
        Toast.makeText(this, "5 Customers Inserted!", Toast.LENGTH_SHORT).show();
    }

    void showAllCustomers() {
        Cursor cursor = db.rawQuery("SELECT * FROM Customer", null);
        StringBuilder sb = new StringBuilder();
        sb.append("ID | Name | Address | Phone\n");
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

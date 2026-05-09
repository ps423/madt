// Slip 24 - Q1: String Uppercase / Lowercase using Toast
// File: StringCaseActivity.java

package com.example.stringcase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class StringCaseActivity extends Activity {

    EditText etString;
    Button btnLower, btnUpper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etString = findViewById(R.id.etString);
        btnLower = findViewById(R.id.btnLower);
        btnUpper = findViewById(R.id.btnUpper);

        btnLower.setOnClickListener(v -> {
            String s = etString.getText().toString();
            if (s.isEmpty()) { Toast.makeText(this, "Enter a string!", Toast.LENGTH_SHORT).show(); return; }
            Toast.makeText(this, "LowerCase: " + s.toLowerCase(), Toast.LENGTH_LONG).show();
        });

        btnUpper.setOnClickListener(v -> {
            String s = etString.getText().toString();
            if (s.isEmpty()) { Toast.makeText(this, "Enter a string!", Toast.LENGTH_SHORT).show(); return; }
            Toast.makeText(this, "UpperCase: " + s.toUpperCase(), Toast.LENGTH_LONG).show();
        });
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <EditText android:id="@+id/etString"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter a string" android:layout_marginBottom="20dp"/>

    <Button android:id="@+id/btnLower"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="LowerCase" android:layout_marginBottom="10dp"/>

    <Button android:id="@+id/btnUpper"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="UpperCase"/>

</LinearLayout>
*/

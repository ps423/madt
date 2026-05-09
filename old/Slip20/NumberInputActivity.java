// Slip 20 - Q1: Accept two numbers, reject if both > 20
// File: NumberInputActivity.java

package com.example.numberinput;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class NumberInputActivity extends Activity {

    EditText etNum1, etNum2;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(v -> {
            String s1 = etNum1.getText().toString().trim();
            String s2 = etNum2.getText().toString().trim();

            if (s1.isEmpty() || s2.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers!", Toast.LENGTH_SHORT).show();
                return;
            }

            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);

            if (n1 > 20 && n2 > 20) {
                tvResult.setText("Both numbers > 20! Input Rejected.\nPlease enter new numbers.");
                tvResult.setTextColor(0xFFCC0000);
                etNum1.setText("");
                etNum2.setText("");
                etNum1.requestFocus();
            } else {
                tvResult.setText("Accepted!\nNumber 1: " + n1 + "\nNumber 2: " + n2);
                tvResult.setTextColor(0xFF006600);
            }
        });
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <EditText android:id="@+id/etNum1"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter first number" android:inputType="number"
        android:layout_marginBottom="12dp"/>

    <EditText android:id="@+id/etNum2"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter second number" android:inputType="number"
        android:layout_marginBottom="20dp"/>

    <Button android:id="@+id/btnSubmit"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Submit" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvResult"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp" android:gravity="center"/>

</LinearLayout>
*/

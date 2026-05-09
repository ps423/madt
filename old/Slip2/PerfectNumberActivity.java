// Slip 2 - Q1: Perfect Number Check using Toast
// File: PerfectNumberActivity.java

package com.example.perfectnumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PerfectNumberActivity extends Activity {

    EditText etNumber;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etNumber.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(PerfectNumberActivity.this, "Enter a number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int num = Integer.parseInt(input);
                if (isPerfect(num)) {
                    Toast.makeText(PerfectNumberActivity.this,
                            num + " is a Perfect Number!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(PerfectNumberActivity.this,
                            num + " is NOT a Perfect Number!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    boolean isPerfect(int n) {
        if (n <= 1) return false;
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        return sum == n;
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Perfect Number Checker"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText
        android:id="@+id/etNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter a number"
        android:inputType="number"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/btnCheck"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Check"/>

</LinearLayout>
*/

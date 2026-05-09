// Slip 14 - Q1: Factorial Calculator
// File: FactorialActivity.java

package com.example.factorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class FactorialActivity extends Activity {

    EditText etNumber;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            String input = etNumber.getText().toString().trim();
            if (input.isEmpty()) {
                tvResult.setText("Please enter a number!");
                return;
            }
            int n = Integer.parseInt(input);
            if (n < 0) {
                tvResult.setText("Factorial not defined for negative numbers!");
                return;
            }
            long fact = factorial(n);
            tvResult.setText("Factorial of " + n + " = " + fact);
        });
    }

    long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Factorial Calculator" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText android:id="@+id/etNumber"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter a number" android:inputType="number"
        android:layout_marginBottom="12dp"/>

    <Button android:id="@+id/btnCalculate"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Calculate Factorial" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvResult"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp" android:gravity="center"/>

</LinearLayout>
*/

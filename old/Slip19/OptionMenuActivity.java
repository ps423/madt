// Slip 19 - Q2: Option Menu - Factorial and Sum of Digits
// File: OptionMenuActivity.java

package com.example.optionmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class OptionMenuActivity extends Activity {

    EditText etNumber;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Find Factorial");
        menu.add(0, 2, 1, "Find Sum of Digits");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String input = etNumber.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Enter a number first!", Toast.LENGTH_SHORT).show();
            return true;
        }
        int n = Integer.parseInt(input);

        switch (item.getItemId()) {
            case 1:
                long fact = factorial(n);
                tvResult.setText("Factorial of " + n + " = " + fact);
                break;
            case 2:
                int sum = sumOfDigits(n);
                tvResult.setText("Sum of digits of " + n + " = " + sum);
                break;
        }
        return true;
    }

    long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    int sumOfDigits(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Option Menu Demo" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText android:id="@+id/etNumber"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter a number" android:inputType="number"
        android:layout_marginBottom="16dp"/>

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="(Open Menu for options)" android:textStyle="italic"
        android:layout_marginBottom="20dp"/>

    <TextView android:id="@+id/tvResult"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp" android:gravity="center"/>

</LinearLayout>
*/

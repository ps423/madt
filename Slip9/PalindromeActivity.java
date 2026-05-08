// Slip 9 - Q1: Palindrome Number Check
// File: PalindromeActivity.java

package com.example.palindrome;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PalindromeActivity extends Activity {

    EditText etGetnum;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGetnum = findViewById(R.id.etGetnum);
        btnCheck = findViewById(R.id.btnCheck);
        tvResult = findViewById(R.id.tvResult);

        btnCheck.setOnClickListener(v -> {
            String input = etGetnum.getText().toString().trim();
            if (input.isEmpty()) {
                tvResult.setText("Please enter a number!");
                return;
            }
            if (isPalindrome(input)) {
                tvResult.setText(input + " is a Palindrome!");
            } else {
                tvResult.setText(input + " is NOT a Palindrome!");
            }
        });
    }

    boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Palindrome Checker" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText android:id="@+id/etGetnum"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter number in getnum" android:inputType="number"
        android:layout_marginBottom="12dp"/>

    <Button android:id="@+id/btnCheck"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Check" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvResult"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp" android:gravity="center"/>

</LinearLayout>
*/

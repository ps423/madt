// Slip 3 - Q2: Phone Number Validation
// File: PhoneValidationActivity.java

package com.example.phonevalidation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Pattern;

public class PhoneValidationActivity extends Activity {

    EditText etPhone;
    Button btnValidate;
    TextView tvResult;

    // Area codes: 040, 041, 050, 0400, 044
    // Total digits (including area code): 6 to 8 in the local part
    // Pattern: (040|041|050|0400|044) followed by 6-8 digits
    // But considering area code length: 040/041/050/044 = 3 digits, 0400 = 4 digits
    // Local part = total - area code length should be part of 6-8 digits
    Pattern phonePattern = Pattern.compile(
            "^(0400\\d{2,4}|040\\d{3,5}|041\\d{3,5}|050\\d{3,5}|044\\d{3,5})$"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhone = findViewById(R.id.etPhone);
        btnValidate = findViewById(R.id.btnValidate);
        tvResult = findViewById(R.id.tvResult);

        btnValidate.setOnClickListener(v -> {
            String phone = etPhone.getText().toString().trim();
            if (phone.isEmpty()) {
                tvResult.setText("Please enter a phone number!");
                return;
            }
            if (phonePattern.matcher(phone).matches()) {
                tvResult.setText("Valid Phone Number: " + phone);
                tvResult.setTextColor(0xFF00AA00);
            } else {
                tvResult.setText("Invalid Phone Number!\nArea code must be: 040, 041, 050, 0400, 044\nTotal length: 9-12 digits");
                tvResult.setTextColor(0xFFCC0000);
            }
        });
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
        android:text="Phone Number Validator"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText
        android:id="@+id/etPhone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter phone number (e.g. 0401234567)"
        android:inputType="phone"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/btnValidate"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Validate"/>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:layout_marginTop="16dp"
        android:gravity="center"/>

</LinearLayout>
*/

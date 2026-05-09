// Slip 11 - Q2: String Operations using RadioButton
// File: StringOpsActivity.java

package com.example.stringops;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class StringOpsActivity extends Activity {

    EditText etString;
    RadioButton rbUppercase, rbLowercase, rbRight5, rbLeft5;
    Button btnClick;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_ops);

        etString = findViewById(R.id.etString);
        rbUppercase = findViewById(R.id.rbUppercase);
        rbLowercase = findViewById(R.id.rbLowercase);
        rbRight5 = findViewById(R.id.rbRight5);
        rbLeft5 = findViewById(R.id.rbLeft5);
        btnClick = findViewById(R.id.btnClick);
        tvOutput = findViewById(R.id.tvOutput);

        btnClick.setOnClickListener(v -> {
            String str = etString.getText().toString();
            if (str.isEmpty()) {
                Toast.makeText(this, "Enter a string!", Toast.LENGTH_SHORT).show();
                return;
            }

            String result = "";
            if (rbUppercase.isChecked()) {
                result = str.toUpperCase();
            } else if (rbLowercase.isChecked()) {
                result = str.toLowerCase();
            } else if (rbRight5.isChecked()) {
                result = str.length() >= 5 ? str.substring(str.length() - 5) : str;
            } else if (rbLeft5.isChecked()) {
                result = str.length() >= 5 ? str.substring(0, 5) : str;
            } else {
                Toast.makeText(this, "Select an operation!", Toast.LENGTH_SHORT).show();
                return;
            }
            tvOutput.setText("Output: " + result);
        });
    }
}

/* activity_string_ops.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp" android:gravity="center">

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="12dp">
        <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
            android:text="Enter String: "/>
        <EditText android:id="@+id/etString" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:hint="hello"/>
    </LinearLayout>

    <RadioGroup android:layout_width="match_parent" android:layout_height="wrap_content"
        android:layout_marginBottom="12dp">
        <RadioButton android:id="@+id/rbUppercase" android:text="Uppercase" android:checked="true"/>
        <RadioButton android:id="@+id/rbLowercase" android:text="Lowercase"/>
        <RadioButton android:id="@+id/rbRight5" android:text="Right 5 Character"/>
        <RadioButton android:id="@+id/rbLeft5" android:text="Left 5 Character"/>
    </RadioGroup>

    <Button android:id="@+id/btnClick" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Click"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal">
        <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
            android:text="Output: "/>
        <TextView android:id="@+id/tvOutput" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:textStyle="bold"/>
    </LinearLayout>

</LinearLayout>
*/

// Slip 22 - Q2: Numeric Operations with RadioButton (Odd/Even, Positive/Negative, Square)
// File: NumericOpsActivity.java

package com.example.numericops;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class NumericOpsActivity extends Activity {

    EditText etNumber;
    RadioButton rbOddEven, rbPosNeg, rbSquare;
    Button btnClick;
    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        rbOddEven = findViewById(R.id.rbOddEven);
        rbPosNeg = findViewById(R.id.rbPosNeg);
        rbSquare = findViewById(R.id.rbSquare);
        btnClick = findViewById(R.id.btnClick);
        tvAnswer = findViewById(R.id.tvAnswer);

        btnClick.setOnClickListener(v -> {
            String input = etNumber.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
                return;
            }
            double num = Double.parseDouble(input);
            String result = "";

            if (rbOddEven.isChecked()) {
                result = ((int) num % 2 == 0) ? "No is Even" : "No is Odd";
            } else if (rbPosNeg.isChecked()) {
                result = (num > 0) ? "No is Positive" : (num < 0) ? "No is Negative" : "No is Zero";
            } else if (rbSquare.isChecked()) {
                result = "Square of " + num + " = " + (num * num);
            } else {
                Toast.makeText(this, "Select an operation!", Toast.LENGTH_SHORT).show();
                return;
            }
            tvAnswer.setText("Ans: " + result);
        });
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp" android:gravity="center"
    android:background="#FFFDE7">

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="12dp">
        <TextView android:text="Enter No : " android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
        <EditText android:id="@+id/etNumber" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:inputType="numberDecimal"/>
    </LinearLayout>

    <RadioGroup android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_marginBottom="12dp">
        <RadioButton android:id="@+id/rbOddEven" android:text="Odd or Even" android:checked="true"/>
        <RadioButton android:id="@+id/rbPosNeg" android:text="Positive or Negative"/>
        <RadioButton android:id="@+id/rbSquare" android:text="Square"/>
    </RadioGroup>

    <Button android:id="@+id/btnClick"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Click" android:layout_marginBottom="12dp"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal">
        <View android:layout_width="0dp" android:layout_height="1dp"
            android:background="#888" android:layout_weight="1"/>
    </LinearLayout>

    <TextView android:id="@+id/tvAnswer"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Ans : " android:textSize="16sp" android:layout_marginTop="8dp"/>

</LinearLayout>
*/

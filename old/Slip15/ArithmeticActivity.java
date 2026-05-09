// Slip 15 - Q1: Two Numbers Arithmetic with Toast
// File: ArithmeticActivity.java

package com.example.arithmetic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class ArithmeticActivity extends Activity {

    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnDiv, btnMult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMult = findViewById(R.id.btnMult);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnDiv.setOnClickListener(v -> calculate('/'));
        btnMult.setOnClickListener(v -> calculate('*'));
    }

    void calculate(char op) {
        String s1 = etNum1.getText().toString().trim();
        String s2 = etNum2.getText().toString().trim();
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers!", Toast.LENGTH_SHORT).show();
            return;
        }
        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double result = 0;
        String opName = "";
        switch (op) {
            case '+': result = n1 + n2; opName = "ADD"; break;
            case '-': result = n1 - n2; opName = "SUB"; break;
            case '*': result = n1 * n2; opName = "MULT"; break;
            case '/':
                if (n2 == 0) { Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT).show(); return; }
                result = n1 / n2; opName = "DIV"; break;
        }
        Toast.makeText(this, opName + ": " + n1 + " " + op + " " + n2 + " = " + result, Toast.LENGTH_LONG).show();
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <EditText android:id="@+id/etNum1" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="Enter first number"
        android:inputType="numberDecimal" android:layout_marginBottom="12dp"/>

    <EditText android:id="@+id/etNum2" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="Enter second number"
        android:inputType="numberDecimal" android:layout_marginBottom="20dp"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button android:id="@+id/btnAdd" android:text="ADD" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnSub" android:text="SUB" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnDiv" android:text="DIV" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnMult" android:text="MULT" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
    </LinearLayout>

</LinearLayout>
*/

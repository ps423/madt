// Slip 2 - Q2: Calculator with all Arithmetic Operations
// File: CalculatorActivity.java

package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

    TextView tvDisplay;
    StringBuilder input = new StringBuilder();
    double num1 = 0, num2 = 0, result = 0;
    char operator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tvDisplay = findViewById(R.id.tvDisplay);

        int[] numBtnIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot};
        String[] numLabels = {"0","1","2","3","4","5","6","7","8","9","."};

        for (int i = 0; i < numBtnIds.length; i++) {
            final String label = numLabels[i];
            Button b = findViewById(numBtnIds[i]);
            b.setOnClickListener(v -> {
                input.append(label);
                tvDisplay.setText(input.toString());
            });
        }

        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnClear = findViewById(R.id.btnClear);

        View.OnClickListener opListener = v -> {
            if (input.length() > 0) {
                num1 = Double.parseDouble(input.toString());
                input.setLength(0);
                Button btn = (Button) v;
                operator = btn.getText().charAt(0);
                tvDisplay.setText(String.valueOf(num1) + " " + operator);
            }
        };

        btnPlus.setOnClickListener(opListener);
        btnMinus.setOnClickListener(opListener);
        btnMul.setOnClickListener(opListener);
        btnDiv.setOnClickListener(opListener);

        btnEquals.setOnClickListener(v -> {
            if (input.length() > 0) {
                num2 = Double.parseDouble(input.toString());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 != 0) result = num1 / num2;
                        else { tvDisplay.setText("Error: Div by 0"); return; }
                        break;
                }
                tvDisplay.setText(String.valueOf(result));
                input.setLength(0);
                input.append(result);
            }
        });

        btnClear.setOnClickListener(v -> {
            input.setLength(0);
            num1 = num2 = result = 0;
            operator = ' ';
            tvDisplay.setText("0");
        });
    }
}

/* activity_calculator.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="8dp"
    android:background="#222">

    <TextView
        android:id="@+id/tvDisplay"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:text="0"
        android:textSize="36sp"
        android:textColor="#FFF"
        android:gravity="end|center_vertical"
        android:background="#333"
        android:padding="8dp"
        android:layout_marginBottom="8dp"/>

    <GridLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:columnCount="4"
        android:rowCount="5">

        <Button android:id="@+id/btn1" android:text="1"/>
        <Button android:id="@+id/btn2" android:text="2"/>
        <Button android:id="@+id/btn3" android:text="3"/>
        <Button android:id="@+id/btnPlus" android:text="+"/>

        <Button android:id="@+id/btn4" android:text="4"/>
        <Button android:id="@+id/btn5" android:text="5"/>
        <Button android:id="@+id/btn6" android:text="6"/>
        <Button android:id="@+id/btnMinus" android:text="-"/>

        <Button android:id="@+id/btn7" android:text="7"/>
        <Button android:id="@+id/btn8" android:text="8"/>
        <Button android:id="@+id/btn9" android:text="9"/>
        <Button android:id="@+id/btnMul" android:text="*"/>

        <Button android:id="@+id/btnDot" android:text="."/>
        <Button android:id="@+id/btn0" android:text="0"/>
        <Button android:id="@+id/btnClear" android:text="C"/>
        <Button android:id="@+id/btnDiv" android:text="/"/>

        <Button android:id="@+id/btnEquals"
            android:text="="
            android:layout_columnSpan="4"
            android:layout_gravity="fill"/>
    </GridLayout>

</LinearLayout>
*/

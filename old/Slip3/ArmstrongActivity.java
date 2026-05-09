// Slip 3 - Q1: Armstrong Number Check
// File: ArmstrongActivity.java

package com.example.armstrong;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ArmstrongActivity extends Activity {

    EditText etNumber;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCheck = findViewById(R.id.btnCheck);
        tvResult = findViewById(R.id.tvResult);

        btnCheck.setOnClickListener(v -> {
            String input = etNumber.getText().toString().trim();
            if (input.isEmpty()) {
                tvResult.setText("Please enter a number!");
                return;
            }
            int num = Integer.parseInt(input);
            if (isArmstrong(num)) {
                tvResult.setText(num + " is an Armstrong Number!");
            } else {
                tvResult.setText(num + " is NOT an Armstrong Number!");
            }
        });
    }

    boolean isArmstrong(int n) {
        int original = n, sum = 0;
        int digits = String.valueOf(n).length();
        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }
}

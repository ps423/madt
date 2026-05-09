// Slip 10 - Q1: Armstrong Number Check using Toast
// File: ArmstrongToastActivity.java

package com.example.armstrongtoast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class ArmstrongToastActivity extends Activity {

    EditText etGetnum;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGetnum = findViewById(R.id.etGetnum);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(v -> {
            String input = etGetnum.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
                return;
            }
            int num = Integer.parseInt(input);
            if (isArmstrong(num)) {
                Toast.makeText(this, num + " is an Armstrong Number!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, num + " is NOT an Armstrong Number!", Toast.LENGTH_LONG).show();
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

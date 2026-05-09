// Slip 11 - Q1: Power and Average Calculator (Two Activities)
// File: MainActivity.java (First Activity)

package com.example.poweravg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText etNum1, etNum2;
    Button btnPower, btnAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnPower = findViewById(R.id.btnPower);
        btnAverage = findViewById(R.id.btnAverage);

        btnPower.setOnClickListener(v -> {
            if (validateInputs()) {
                double n1 = Double.parseDouble(etNum1.getText().toString());
                double n2 = Double.parseDouble(etNum2.getText().toString());
                double result = Math.pow(n1, n2);
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("result", n1 + " ^ " + n2 + " = " + result);
                startActivity(intent);
            }
        });

        btnAverage.setOnClickListener(v -> {
            if (validateInputs()) {
                double n1 = Double.parseDouble(etNum1.getText().toString());
                double n2 = Double.parseDouble(etNum2.getText().toString());
                double result = (n1 + n2) / 2;
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("result", "Average of " + n1 + " and " + n2 + " = " + result);
                startActivity(intent);
            }
        });
    }

    boolean validateInputs() {
        if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter both numbers!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

// ============================================================
// File: ResultActivity.java (Second Activity)

/*
package com.example.poweravg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    TextView tvResult;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);

        String result = getIntent().getStringExtra("result");
        tvResult.setText(result);

        btnBack.setOnClickListener(v -> finish());
    }
}
*/

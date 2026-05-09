// Slip 16 - SecondActivity.java

package com.example.intentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView tvPlayerName;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvPlayerName = findViewById(R.id.tvPlayerName);
        btnBack = findViewById(R.id.btnBack);

        String playerName = getIntent().getStringExtra("playerName");
        String message = getIntent().getStringExtra("message");

        tvPlayerName.setText("Message: " + message + "\nPlayer Name: " + playerName);

        btnBack.setOnClickListener(v -> finish()); // Back to FirstActivity
    }
}

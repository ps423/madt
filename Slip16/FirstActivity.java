// Slip 16 - Q1 & Q2: Intent - Send data between two Activities
// File: FirstActivity.java

package com.example.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class FirstActivity extends Activity {

    EditText etPlayerName;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etPlayerName = findViewById(R.id.etPlayerName);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String name = etPlayerName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Enter player name!", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("playerName", name);
            intent.putExtra("message", "Hello");
            startActivity(intent);
        });
    }
}

// ====================================================
// File: SecondActivity.java

/*
package com.example.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

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

        btnBack.setOnClickListener(v -> {
            finish(); // Goes back to FirstActivity
        });
    }
}
*/

/* activity_first.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="First Activity" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText android:id="@+id/etPlayerName"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter Player Name" android:layout_marginBottom="16dp"/>

    <Button android:id="@+id/btnSend"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Send to Second Activity"/>

</LinearLayout>
*/

/* activity_second.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Second Activity" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <TextView android:id="@+id/tvPlayerName"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="18sp" android:gravity="center"
        android:layout_marginBottom="30dp"/>

    <Button android:id="@+id/btnBack"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="BACK"/>

</LinearLayout>
*/

// Slip 7 - Q1: ProgressBar Demo
// File: ProgressBarActivity.java

package com.example.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends Activity {

    ProgressBar progressBar;
    TextView tvProgress;
    Button btnStart, btnReset;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tvProgress);
        btnStart = findViewById(R.id.btnStart);
        btnReset = findViewById(R.id.btnReset);

        btnStart.setOnClickListener(v -> startProgress());

        btnReset.setOnClickListener(v -> {
            progressStatus = 0;
            progressBar.setProgress(0);
            tvProgress.setText("0%");
        });
    }

    void startProgress() {
        progressStatus = 0;
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 5;
                try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
                handler.post(() -> {
                    progressBar.setProgress(progressStatus);
                    tvProgress.setText(progressStatus + "%");
                });
            }
            handler.post(() -> tvProgress.setText("Complete!"));
        }).start();
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Progress Bar Demo" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="30dp"/>

    <ProgressBar android:id="@+id/progressBar"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:max="100" android:progress="0" android:layout_marginBottom="10dp"/>

    <TextView android:id="@+id/tvProgress"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="0%" android:textSize="18sp" android:layout_marginBottom="20dp"/>

    <Button android:id="@+id/btnStart"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Start Progress" android:layout_marginBottom="10dp"/>

    <Button android:id="@+id/btnReset"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Reset"/>

</LinearLayout>
*/

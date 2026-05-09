// Slip 8 & 17 & 21 - Q1: Activity Lifecycle Demo
// File: ActivityLifecycleDemo.java

package com.example.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

public class ActivityLifecycleDemo extends Activity {

    TextView tvLog;
    StringBuilder logText = new StringBuilder();
    static final String TAG = "ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = findViewById(R.id.tvLog);
        addLog("onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        addLog("onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        addLog("onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        addLog("onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        addLog("onStop() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addLog("onRestart() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        addLog("onDestroy() called");
    }

    void addLog(String message) {
        Log.d(TAG, message);
        logText.append(message).append("\n");
        if (tvLog != null) tvLog.setText(logText.toString());
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:padding="16dp">

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
            android:text="Activity Lifecycle Demo" android:textSize="22sp"
            android:textStyle="bold" android:layout_marginBottom="16dp"/>

        <TextView android:id="@+id/tvLog"
            android:layout_width="match_parent" android:layout_height="wrap_content"
            android:textSize="14sp" android:fontFamily="monospace"
            android:background="#F5F5F5" android:padding="8dp"/>

    </LinearLayout>
</ScrollView>
*/

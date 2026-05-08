// Slip 23 - Q1: Implicit Intent Demo
// File: ImplicitIntentActivity.java

package com.example.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;

public class ImplicitIntentActivity extends Activity {

    Button btnCall, btnBrowser, btnMap, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnBrowser = findViewById(R.id.btnBrowser);
        btnMap = findViewById(R.id.btnMap);
        btnShare = findViewById(R.id.btnShare);

        // 1. Make a phone call
        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9876543210"));
            startActivity(intent);
        });

        // 2. Open a webpage
        btnBrowser.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // 3. Open a location on map
        btnMap.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:18.5204,73.8567?q=Pune"));
            startActivity(intent);
        });

        // 4. Share text
        btnShare.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from Android Implicit Intent!");
            startActivity(Intent.createChooser(intent, "Share via"));
        });
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Implicit Intent Demo" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="30dp"/>

    <Button android:id="@+id/btnCall"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Make Phone Call" android:layout_marginBottom="10dp"/>

    <Button android:id="@+id/btnBrowser"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Open Browser" android:layout_marginBottom="10dp"/>

    <Button android:id="@+id/btnMap"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Open Map" android:layout_marginBottom="10dp"/>

    <Button android:id="@+id/btnShare"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Share Text"/>

</LinearLayout>
*/

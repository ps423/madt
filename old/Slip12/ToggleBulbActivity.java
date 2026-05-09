// Slip 12 - Q1: Toggle Light Bulb ON/OFF
// File: ToggleBulbActivity.java

package com.example.togglebulb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ToggleBulbActivity extends Activity {

    ToggleButton toggleButton;
    ImageView imgBulb;
    boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        imgBulb = findViewById(R.id.imgBulb);

        // Set initial image (bulb off)
        imgBulb.setImageResource(android.R.drawable.btn_star_big_off);

        toggleButton.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                // Bulb ON
                imgBulb.setImageResource(android.R.drawable.btn_star_big_on);
                imgBulb.setBackgroundColor(0xFFFFFF00); // Yellow background
            } else {
                // Bulb OFF
                imgBulb.setImageResource(android.R.drawable.btn_star_big_off);
                imgBulb.setBackgroundColor(0xFFCCCCCC); // Gray background
            }
        });
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:gravity="center" android:padding="20dp">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Light Bulb Toggle" android:textSize="24sp" android:textStyle="bold"
        android:layout_marginBottom="30dp"/>

    <ImageView android:id="@+id/imgBulb"
        android:layout_width="150dp" android:layout_height="150dp"
        android:src="@android:drawable/btn_star_big_off"
        android:scaleType="fitCenter"
        android:layout_marginBottom="30dp"/>

    <ToggleButton android:id="@+id/toggleButton"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textOn="Bulb ON" android:textOff="Bulb OFF"
        android:textSize="18sp"/>

</LinearLayout>
*/

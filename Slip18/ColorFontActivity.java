// Slip 18 - Q1: Change Background Color and Font Size using XML
// File: ColorFontActivity.java

package com.example.colorfont;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

public class ColorFontActivity extends Activity {

    TextView tvText;
    Button btnRedBg, btnBlueBg, btnGreenBg;
    Button btnSmall, btnMedium, btnLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_font);

        tvText = findViewById(R.id.tvText);
        btnRedBg = findViewById(R.id.btnRedBg);
        btnBlueBg = findViewById(R.id.btnBlueBg);
        btnGreenBg = findViewById(R.id.btnGreenBg);
        btnSmall = findViewById(R.id.btnSmall);
        btnMedium = findViewById(R.id.btnMedium);
        btnLarge = findViewById(R.id.btnLarge);

        btnRedBg.setOnClickListener(v -> tvText.setBackgroundColor(Color.RED));
        btnBlueBg.setOnClickListener(v -> tvText.setBackgroundColor(Color.BLUE));
        btnGreenBg.setOnClickListener(v -> tvText.setBackgroundColor(Color.GREEN));

        btnSmall.setOnClickListener(v -> tvText.setTextSize(14f));
        btnMedium.setOnClickListener(v -> tvText.setTextSize(22f));
        btnLarge.setOnClickListener(v -> tvText.setTextSize(32f));
    }
}

/* activity_color_font.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp" android:gravity="center">

    <TextView android:id="@+id/tvText"
        android:layout_width="match_parent" android:layout_height="80dp"
        android:text="Hello Android!" android:textSize="22sp"
        android:gravity="center" android:background="#EEEEEE"
        android:layout_marginBottom="20dp"/>

    <TextView android:text="Change Background Color:" android:textStyle="bold"
        android:layout_width="wrap_content" android:layout_height="wrap_content"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="16dp">
        <Button android:id="@+id/btnRedBg" android:text="Red" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content" android:backgroundTint="#FF0000"/>
        <Button android:id="@+id/btnBlueBg" android:text="Blue" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content" android:backgroundTint="#0000FF"/>
        <Button android:id="@+id/btnGreenBg" android:text="Green" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content" android:backgroundTint="#00AA00"/>
    </LinearLayout>

    <TextView android:text="Change Font Size:" android:textStyle="bold"
        android:layout_width="wrap_content" android:layout_height="wrap_content"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button android:id="@+id/btnSmall" android:text="Small" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnMedium" android:text="Medium" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnLarge" android:text="Large" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
    </LinearLayout>

</LinearLayout>
*/

// Slip 19 & 22 - Q1: Change Image on Screen
// File: ChangeImageActivity.java

package com.example.changeimage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class ChangeImageActivity extends Activity {

    ImageView imageView;
    Button btnImg1, btnImg2, btnImg3;

    int[] images = {
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_mapmode
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnImg1 = findViewById(R.id.btnImg1);
        btnImg2 = findViewById(R.id.btnImg2);
        btnImg3 = findViewById(R.id.btnImg3);

        imageView.setImageResource(images[0]);

        btnImg1.setOnClickListener(v -> {
            imageView.setImageResource(images[0]);
            Toast.makeText(this, "Camera Image", Toast.LENGTH_SHORT).show();
        });
        btnImg2.setOnClickListener(v -> {
            imageView.setImageResource(images[1]);
            Toast.makeText(this, "Gallery Image", Toast.LENGTH_SHORT).show();
        });
        btnImg3.setOnClickListener(v -> {
            imageView.setImageResource(images[2]);
            Toast.makeText(this, "Map Image", Toast.LENGTH_SHORT).show();
        });
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Change Image Demo" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <ImageView android:id="@+id/imageView"
        android:layout_width="200dp" android:layout_height="200dp"
        android:scaleType="fitCenter" android:layout_marginBottom="20dp"/>

    <Button android:id="@+id/btnImg1"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Image 1 (Camera)"/>

    <Button android:id="@+id/btnImg2"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Image 2 (Gallery)"/>

    <Button android:id="@+id/btnImg3"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Image 3 (Map)"/>

</LinearLayout>
*/

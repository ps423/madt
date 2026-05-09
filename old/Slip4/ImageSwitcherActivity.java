// Slip 4 - Q1: Image Switcher using setFactory()
// File: ImageSwitcherActivity.java

package com.example.imageswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherActivity extends Activity {

    ImageSwitcher imageSwitcher;
    Button btnNext, btnPrev;
    int[] images = {
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_mapmode,
            android.R.drawable.ic_menu_compass,
            android.R.drawable.ic_menu_info_details
    };
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        // setFactory() - required method
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        // Set animations
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));

        // Set initial image
        imageSwitcher.setImageResource(images[currentIndex]);

        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % images.length;
            imageSwitcher.setImageResource(images[currentIndex]);
        });

        btnPrev.setOnClickListener(v -> {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            imageSwitcher.setImageResource(images[currentIndex]);
        });
    }
}

/* activity_image_switcher.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Image Switcher"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <ImageSwitcher
        android:id="@+id/imageSwitcher"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_marginBottom="20dp"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center">

        <Button
            android:id="@+id/btnPrev"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Previous"
            android:layout_marginEnd="16dp"/>

        <Button
            android:id="@+id/btnNext"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Next"/>
    </LinearLayout>

</LinearLayout>
*/

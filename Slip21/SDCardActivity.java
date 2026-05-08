// Slip 21 - Q2: Write Data to SD Card
// File: SDCardActivity.java

package com.example.sdcard;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.*;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.*;

public class SDCardActivity extends Activity {

    EditText etData;
    Button btnWrite, btnClear;
    TextView tvStatus;

    static final int STORAGE_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        etData = findViewById(R.id.etData);
        btnWrite = findViewById(R.id.btnWrite);
        btnClear = findViewById(R.id.btnClear);
        tvStatus = findViewById(R.id.tvStatus);

        // Request permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION);
        }

        btnWrite.setOnClickListener(v -> writeToSDCard());

        btnClear.setOnClickListener(v -> {
            etData.setText("");
            tvStatus.setText("");
        });
    }

    void writeToSDCard() {
        String data = etData.getText().toString().trim();
        if (data.isEmpty()) {
            Toast.makeText(this, "Enter data to write!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                File sdCard = Environment.getExternalStorageDirectory();
                File file = new File(sdCard, "mydata.txt");
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(data);
                bw.newLine();
                bw.close();
                tvStatus.setText("Data Written in SDCARD\nFile: " + file.getAbsolutePath());
                Toast.makeText(this, "Data written successfully!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                tvStatus.setText("Error: " + e.getMessage());
            }
        } else {
            tvStatus.setText("SD Card not available!");
        }
    }
}

/* activity_sdcard.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp" android:gravity="center">

    <EditText android:id="@+id/etData"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter data to write" android:layout_marginBottom="12dp"/>

    <Button android:id="@+id/btnWrite"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="WRITE DATA" android:layout_marginBottom="8dp"/>

    <Button android:id="@+id/btnClear"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="CLEAR" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvStatus"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:textSize="14sp" android:gravity="center"/>

</LinearLayout>

<!-- AndroidManifest.xml - Add permission:
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
-->
*/

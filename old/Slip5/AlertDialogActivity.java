// Slip 5 - Q1: Alert Dialog Box Demo
// File: AlertDialogActivity.java

package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {

    Button btnShowAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowAlert = findViewById(R.id.btnShowAlert);

        btnShowAlert.setOnClickListener(v -> showAlertDialog());
    }

    void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Are you sure you want to exit?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("Yes", (dialog, which) -> {
            Toast.makeText(AlertDialogActivity.this, "You clicked YES", Toast.LENGTH_SHORT).show();
            finish();
        });

        builder.setNegativeButton("No", (dialog, which) -> {
            Toast.makeText(AlertDialogActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });

        builder.setNeutralButton("Cancel", (dialog, which) -> {
            Toast.makeText(AlertDialogActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

/* activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="20dp">

    <Button
        android:id="@+id/btnShowAlert"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Show Alert Dialog"/>

</LinearLayout>
*/

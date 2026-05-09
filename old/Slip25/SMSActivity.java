// Slip 25 - Q1: SMS Activity
// File: SMSActivity.java

package com.example.smsapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.*;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SMSActivity extends Activity {

    EditText etPhone, etMessage;
    Button btnSend;
    static final int SMS_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etPhone = findViewById(R.id.etPhone);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION);
        }

        btnSend.setOnClickListener(v -> sendSMS());
    }

    void sendSMS() {
        String phone = etPhone.getText().toString().trim();
        String message = etMessage.getText().toString().trim();

        if (phone.isEmpty()) { etPhone.setError("Enter phone number!"); return; }
        if (message.isEmpty()) { etMessage.setError("Enter message!"); return; }

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, message, null, null);
            Toast.makeText(this, "SMS Sent to " + phone, Toast.LENGTH_LONG).show();
            etPhone.setText("");
            etMessage.setText("");
        } catch (Exception e) {
            Toast.makeText(this, "SMS Failed! " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

/* activity_sms.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="20dp">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="SMS Application" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <EditText android:id="@+id/etPhone"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter phone number" android:inputType="phone"
        android:layout_marginBottom="12dp"/>

    <EditText android:id="@+id/etMessage"
        android:layout_width="match_parent" android:layout_height="100dp"
        android:hint="Enter message" android:gravity="top"
        android:layout_marginBottom="16dp"/>

    <Button android:id="@+id/btnSend"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Send SMS"/>

</LinearLayout>

<!-- AndroidManifest.xml - Add permission:
<uses-permission android:name="android.permission.SEND_SMS"/>
-->
*/

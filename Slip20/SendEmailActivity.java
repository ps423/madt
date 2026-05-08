// Slip 20 - Q2: Send Email with Attachment using Intent
// File: SendEmailActivity.java

package com.example.sendemail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;

public class SendEmailActivity extends Activity {

    EditText etTo, etSubject, etBody;
    Button btnSendEmail, btnAttach;
    TextView tvAttachStatus;
    Uri attachmentUri = null;

    static final int PICK_FILE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etTo = findViewById(R.id.etTo);
        etSubject = findViewById(R.id.etSubject);
        etBody = findViewById(R.id.etBody);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnAttach = findViewById(R.id.btnAttach);
        tvAttachStatus = findViewById(R.id.tvAttachStatus);

        btnAttach.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            startActivityForResult(intent, PICK_FILE);
        });

        btnSendEmail.setOnClickListener(v -> sendEmail());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE && resultCode == RESULT_OK && data != null) {
            attachmentUri = data.getData();
            tvAttachStatus.setText("Attachment: " + attachmentUri.getLastPathSegment());
        }
    }

    void sendEmail() {
        String to = etTo.getText().toString().trim();
        String subject = etSubject.getText().toString().trim();
        String body = etBody.getText().toString().trim();

        if (to.isEmpty()) {
            etTo.setError("Enter recipient email!");
            return;
        }

        Intent emailIntent;
        if (attachmentUri != null) {
            emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_STREAM, attachmentUri);
            emailIntent.setType("message/rfc822");
        } else {
            emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:"));
        }

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send Email via..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No email app found!", Toast.LENGTH_SHORT).show();
        }
    }
}

/* activity_email.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Send Email" android:textSize="22sp" android:textStyle="bold"
        android:layout_marginBottom="16dp"/>

    <EditText android:id="@+id/etTo" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="To (email)" android:inputType="textEmailAddress"/>
    <EditText android:id="@+id/etSubject" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="Subject"/>
    <EditText android:id="@+id/etBody" android:layout_width="match_parent"
        android:layout_height="100dp" android:hint="Message body" android:gravity="top"/>

    <Button android:id="@+id/btnAttach"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Add Attachment" android:layout_marginTop="8dp"/>

    <TextView android:id="@+id/tvAttachStatus"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="No attachment" android:layout_marginBottom="8dp"/>

    <Button android:id="@+id/btnSendEmail"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Send Email"/>

</LinearLayout>
*/

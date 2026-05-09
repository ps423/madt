# Slip 25 - Question 1 - SMS Activity

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/mobile" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Mobile" android:inputType="phone"/>
    <EditText android:id="@+id/message" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Message"/>
    <Button android:id="@+id/send" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Send SMS"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
        }

        EditText mobile = findViewById(R.id.mobile);
        EditText message = findViewById(R.id.message);
        Button send = findViewById(R.id.send);

        send.setOnClickListener(v -> {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(mobile.getText().toString(), null, message.getText().toString(), null, null);
            Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
        });
    }
}
```

## AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.SEND_SMS" />
```

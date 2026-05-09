# Slip 20 - Question 2 - Email Attachment

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/to" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="To"/>
    <EditText android:id="@+id/subject" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Subject"/>
    <EditText android:id="@+id/body" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Message"/>
    <Button android:id="@+id/send" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Send"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText to=findViewById(R.id.to), subject=findViewById(R.id.subject), body=findViewById(R.id.body);
        findViewById(R.id.send).setOnClickListener(v->{
            Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
            i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
            i.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/Download/sample.pdf"));
            startActivity(Intent.createChooser(i, "Send Email"));
        });
    }
}
```

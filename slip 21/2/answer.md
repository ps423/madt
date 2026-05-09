# Slip 21 - Question 2 - Write Data To SD Card

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/data" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter data"/>
    <Button android:id="@+id/save" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Save"/>
    <TextView android:id="@+id/result" android:layout_width="match_parent" android:layout_height="wrap_content"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText data=findViewById(R.id.data); TextView result=findViewById(R.id.result);
        findViewById(R.id.save).setOnClickListener(v->{
            try{ File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "madt.txt"); FileOutputStream fos=new FileOutputStream(file); fos.write(data.getText().toString().getBytes()); fos.close(); result.setText("Saved: "+file.getAbsolutePath()); }
            catch(Exception e){ result.setText(e.getMessage()); }
        });
    }
}
```

## AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

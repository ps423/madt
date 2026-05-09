# Slip 7 - Question 1 - ProgressBar

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <ProgressBar android:id="@+id/progress" style="?android:attr/progressBarStyleHorizontal" android:layout_width="match_parent" android:layout_height="wrap_content" android:max="100"/>
    <Button android:id="@+id/start" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Start"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        ProgressBar pb=findViewById(R.id.progress);
        findViewById(R.id.start).setOnClickListener(v -> new Thread(() -> {
            for(int i=0;i<=100;i+=10){ int value=i; runOnUiThread(() -> pb.setProgress(value)); try{Thread.sleep(300);}catch(Exception e){} }
        }).start());
    }
}
```

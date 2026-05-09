# Slip 21 - Question 1 - Activity Life Cycle

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <TextView android:id="@+id/log" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="20sp"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView log;
    void add(String s){ log.append(s + "\n"); }
    @Override protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_main); log=findViewById(R.id.log); add("onCreate"); }
    @Override protected void onStart(){ super.onStart(); add("onStart"); }
    @Override protected void onResume(){ super.onResume(); add("onResume"); }
    @Override protected void onPause(){ super.onPause(); add("onPause"); }
    @Override protected void onStop(){ super.onStop(); add("onStop"); }
    @Override protected void onRestart(){ super.onRestart(); add("onRestart"); }
    @Override protected void onDestroy(){ super.onDestroy(); }
}
```

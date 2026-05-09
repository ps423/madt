# Slip 12 - Question 1 - Toggle Bulb

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <TextView android:id="@+id/bulb" android:layout_width="match_parent" android:layout_height="200dp" android:gravity="center" android:text="OFF" android:textSize="40sp" android:background="#444444"/>
    <ToggleButton android:id="@+id/toggle" android:layout_width="match_parent" android:layout_height="wrap_content" android:textOn="ON" android:textOff="OFF"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        TextView bulb=findViewById(R.id.bulb); ToggleButton toggle=findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener((button,isOn)->{ bulb.setText(isOn?"ON":"OFF"); bulb.setBackgroundColor(isOn?Color.YELLOW:Color.DKGRAY); });
    }
}
```

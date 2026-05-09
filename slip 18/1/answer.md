# Slip 18 - Question 1 - XML Color Font

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:background="#E3F2FD">
    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Welcome" android:textSize="32sp" android:textColor="#D32F2F" android:textStyle="bold"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
    }
}
```

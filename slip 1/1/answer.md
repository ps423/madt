# Slip 1 - Question 1 - Splash Screen

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <TextView android:layout_width="match_parent" android:layout_height="match_parent" android:gravity="center" android:text="MADT App" android:textSize="34sp" android:textStyle="bold"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }, 3000);
    }
}
```

## AndroidManifest.xml

```xml
<activity android:name=".HomeActivity" />
```

## activity_home.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <TextView android:layout_width="match_parent" android:layout_height="match_parent" android:gravity="center" android:text="Home Screen" android:textSize="28sp"/>
</LinearLayout>
```

## HomeActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
```

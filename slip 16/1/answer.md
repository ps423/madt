# Slip 16 - Question 1 - Intent Button

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <Button android:id="@+id/next" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Open Second Activity"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        findViewById(R.id.next).setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
    }
}
```

## activity_second.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <Button android:id="@+id/back" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="BACK"/>
</LinearLayout>
```

## SecondActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_second);
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}
```

## AndroidManifest.xml

```xml
<activity android:name=".SecondActivity" />
```

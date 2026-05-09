# Slip 24 - Question 1 - Upper Lower Toast

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/input" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter string"/>
    <Button android:id="@+id/upper" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Uppercase"/>
    <Button android:id="@+id/lower" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Lowercase"/>
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
        EditText input=findViewById(R.id.input);
        findViewById(R.id.upper).setOnClickListener(v -> Toast.makeText(this, input.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show());
        findViewById(R.id.lower).setOnClickListener(v -> Toast.makeText(this, input.getText().toString().toLowerCase(), Toast.LENGTH_SHORT).show());
    }
}
```

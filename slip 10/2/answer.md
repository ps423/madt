# Slip 10 - Question 2 - Spinner Buttons GUI

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <Spinner android:id="@+id/spinner" android:layout_width="match_parent" android:layout_height="wrap_content"/>
    <Button android:id="@+id/ok" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="OK"/>
    <Button android:id="@+id/cancel" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Cancel"/>
    <TextView android:id="@+id/result" android:layout_width="match_parent" android:layout_height="wrap_content"/>
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
        Spinner sp=findViewById(R.id.spinner); TextView result=findViewById(R.id.result);
        String[] items={"Java","Android","SQLite","Intent"};
        sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items));
        findViewById(R.id.ok).setOnClickListener(v -> result.setText("Selected: " + sp.getSelectedItem()));
        findViewById(R.id.cancel).setOnClickListener(v -> result.setText(""));
    }
}
```

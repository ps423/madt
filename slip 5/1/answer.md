# Slip 5 - Question 1 - AlertDialog

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <Button android:id="@+id/show" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Show Alert"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        findViewById(R.id.show).setOnClickListener(v -> new AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Do you want to continue?")
            .setPositiveButton("Yes", (d,w)->Toast.makeText(this,"Yes clicked",Toast.LENGTH_SHORT).show())
            .setNegativeButton("No", null)
            .show());
    }
}
```

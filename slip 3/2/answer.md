# Slip 3 - Question 2 - Phone Number Validation

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/phone" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter phone number" android:inputType="phone"/>
    <Button android:id="@+id/check" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Validate"/>
    <TextView android:id="@+id/result" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="20sp"/>
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
        EditText phone=findViewById(R.id.phone);
        TextView result=findViewById(R.id.result);
        findViewById(R.id.check).setOnClickListener(v->{
            String p=phone.getText().toString();
            boolean ok=p.matches("^(040|041|050|0400|044)[0-9]{6,8}$");
            result.setText(ok ? "Valid phone number" : "Invalid phone number");
        });
    }
}
```

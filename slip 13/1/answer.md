# Slip 13 - Question 1 - Registration Validation

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/name" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Name"/>
    <EditText android:id="@+id/email" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Email"/>
    <EditText android:id="@+id/mobile" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Mobile"/>
    <Button android:id="@+id/register" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Register"/>
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
        EditText name=findViewById(R.id.name), email=findViewById(R.id.email), mobile=findViewById(R.id.mobile); TextView result=findViewById(R.id.result);
        findViewById(R.id.register).setOnClickListener(v->{
            if(name.getText().toString().isEmpty()) result.setText("Name required");
            else if(!email.getText().toString().contains("@")) result.setText("Invalid email");
            else if(mobile.getText().toString().length()!=10) result.setText("Invalid mobile");
            else result.setText("Registration successful");
        });
    }
}
```

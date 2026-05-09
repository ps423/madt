# Slip 6 - Question 1 - Login Validation

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/email" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Email"/>
    <EditText android:id="@+id/pass" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Password" android:inputType="textPassword"/>
    <Button android:id="@+id/login" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="LOGIN"/>
    <TextView android:id="@+id/msg" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="18sp"/>
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
        EditText email=findViewById(R.id.email), pass=findViewById(R.id.pass);
        TextView msg=findViewById(R.id.msg);
        findViewById(R.id.login).setOnClickListener(v->{
            String e=email.getText().toString();
            String p=pass.getText().toString();
            if(e.isEmpty() || p.isEmpty()) msg.setText("All fields are required");
            else if(!e.contains("@")) msg.setText("Invalid email");
            else if(p.length()<6) msg.setText("Password must be at least 6 characters");
            else msg.setText("Login successful");
        });
    }
}
```

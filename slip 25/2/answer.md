# Slip 25 - Question 2 - Login Table Layout

## activity_main.xml

```xml
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent" android:layout_height="match_parent" android:padding="20dp">
    <TableRow><TextView android:text="Email"/><EditText android:id="@+id/email" android:hint="Email"/></TableRow>
    <TableRow><TextView android:text="Password"/><EditText android:id="@+id/pass" android:hint="Password" android:inputType="textPassword"/></TableRow>
    <Button android:id="@+id/login" android:text="LOGIN"/>
    <TextView android:id="@+id/msg"/>
</TableLayout>
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

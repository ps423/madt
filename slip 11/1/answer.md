# Slip 11 - Question 1 - Power And Average

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/a" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="First number"/>
    <EditText android:id="@+id/b" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Second number"/>
    <Button android:id="@+id/power" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Power"/>
    <Button android:id="@+id/avg" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Average"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText a=findViewById(R.id.a), c=findViewById(R.id.b);
        findViewById(R.id.power).setOnClickListener(v -> open("Power = " + Math.pow(Double.parseDouble(a.getText().toString()), Double.parseDouble(c.getText().toString()))));
        findViewById(R.id.avg).setOnClickListener(v -> open("Average = " + ((Double.parseDouble(a.getText().toString()) + Double.parseDouble(c.getText().toString())) / 2)));
    }
    void open(String ans){ Intent i=new Intent(this, ResultActivity.class); i.putExtra("ans", ans); startActivity(i); }
}
```

## activity_result.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <TextView android:id="@+id/result" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="24sp"/>
</LinearLayout>
```

## ResultActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_result);
        TextView result=findViewById(R.id.result);
        result.setText(getIntent().getStringExtra("ans"));
    }
}
```

## AndroidManifest.xml

```xml
<activity android:name=".ResultActivity" />
```

# Slip 9 - Question 2 - Simple Calculator

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/a" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="First number" android:inputType="numberDecimal"/>
    <EditText android:id="@+id/b" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Second number" android:inputType="numberDecimal"/>
    <Button android:id="@+id/add" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="ADD"/>
    <Button android:id="@+id/sub" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="SUB"/>
    <Button android:id="@+id/mul" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="MULT"/>
    <Button android:id="@+id/div" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="DIV"/>
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
    EditText a, b;
    TextView result;

    double x(){ return Double.parseDouble(a.getText().toString()); }
    double y(){ return Double.parseDouble(b.getText().toString()); }

    void show(String msg){
        result.setText(msg);
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        result = findViewById(R.id.result);

        findViewById(R.id.add).setOnClickListener(v -> show("Addition = " + (x() + y())));
        findViewById(R.id.sub).setOnClickListener(v -> show("Subtraction = " + (x() - y())));
        findViewById(R.id.mul).setOnClickListener(v -> show("Multiplication = " + (x() * y())));
        findViewById(R.id.div).setOnClickListener(v -> {
            if (y() == 0) show("Cannot divide by zero");
            else show("Division = " + (x() / y()));
        });
    }
}
```

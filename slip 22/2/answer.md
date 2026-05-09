# Slip 22 - Question 2 - Numeric Radio Operations

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/a" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="First number"/>
    <EditText android:id="@+id/b" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Second number"/>
    <RadioGroup android:id="@+id/group" android:layout_width="match_parent" android:layout_height="wrap_content">
        <RadioButton android:id="@+id/add" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Add"/>
        <RadioButton android:id="@+id/sub" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Subtract"/>
        <RadioButton android:id="@+id/mul" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Multiply"/>
        <RadioButton android:id="@+id/div" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Divide"/>
    </RadioGroup>
    <Button android:id="@+id/show" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Show"/>
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
        EditText a=findViewById(R.id.a), c=findViewById(R.id.b); RadioGroup group=findViewById(R.id.group); TextView result=findViewById(R.id.result);
        findViewById(R.id.show).setOnClickListener(v->{ double x=Double.parseDouble(a.getText().toString()), y=Double.parseDouble(c.getText().toString()); int id=group.getCheckedRadioButtonId(); if(id==R.id.add) result.setText("Result = "+(x+y)); else if(id==R.id.sub) result.setText("Result = "+(x-y)); else if(id==R.id.mul) result.setText("Result = "+(x*y)); else if(id==R.id.div) result.setText(y==0?"Cannot divide by zero":"Result = "+(x/y)); });
    }
}
```

# Slip 11 - Question 2 - String Operations

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/input" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter string"/>
    <RadioGroup android:id="@+id/group" android:layout_width="match_parent" android:layout_height="wrap_content">
        <RadioButton android:id="@+id/upper" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Uppercase"/>
        <RadioButton android:id="@+id/lower" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Lowercase"/>
        <RadioButton android:id="@+id/reverse" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Reverse"/>
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
        EditText input=findViewById(R.id.input); TextView result=findViewById(R.id.result); RadioGroup group=findViewById(R.id.group);
        findViewById(R.id.show).setOnClickListener(v->{
            String s=input.getText().toString(); int id=group.getCheckedRadioButtonId();
            if(id==R.id.upper) result.setText(s.toUpperCase());
            else if(id==R.id.lower) result.setText(s.toLowerCase());
            else if(id==R.id.reverse) result.setText(new StringBuilder(s).reverse().toString());
        });
    }
}
```

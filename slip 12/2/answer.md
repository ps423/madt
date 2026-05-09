# Slip 12 - Question 2 - Formatted Label

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/first" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="First name"/>
    <EditText android:id="@+id/last" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Last name"/>
    <CheckBox android:id="@+id/bold" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Bold"/>
    <CheckBox android:id="@+id/italic" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Italic"/>
    <CheckBox android:id="@+id/under" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Underline"/>
    <RadioGroup android:id="@+id/colors" android:layout_width="match_parent" android:layout_height="wrap_content">
        <RadioButton android:id="@+id/red" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Red"/>
        <RadioButton android:id="@+id/blue" android:layout_width="wrap_content" android:layout_height="wrap_content" android:text="Blue"/>
    </RadioGroup>
    <Button android:id="@+id/display" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Display"/>
    <Button android:id="@+id/clear" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Clear"/>
    <Button android:id="@+id/exit" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Exit"/>
    <TextView android:id="@+id/label" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="24sp"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.*;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText first=findViewById(R.id.first), last=findViewById(R.id.last);
        CheckBox bold=findViewById(R.id.bold), italic=findViewById(R.id.italic), under=findViewById(R.id.under);
        RadioGroup colors=findViewById(R.id.colors);
        TextView label=findViewById(R.id.label);
        findViewById(R.id.display).setOnClickListener(v->{
            label.setText(first.getText().toString()+" "+last.getText().toString());
            int style=Typeface.NORMAL;
            if(bold.isChecked() && italic.isChecked()) style=Typeface.BOLD_ITALIC;
            else if(bold.isChecked()) style=Typeface.BOLD;
            else if(italic.isChecked()) style=Typeface.ITALIC;
            label.setTypeface(Typeface.DEFAULT, style);
            if(under.isChecked()) label.setPaintFlags(label.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            else label.setPaintFlags(label.getPaintFlags() & ~Paint.UNDERLINE_TEXT_FLAG);
            label.setTextColor(colors.getCheckedRadioButtonId()==R.id.red ? Color.RED : Color.BLUE);
        });
        findViewById(R.id.clear).setOnClickListener(v->{ first.setText(""); last.setText(""); label.setText(""); });
        findViewById(R.id.exit).setOnClickListener(v->finish());
    }
}
```

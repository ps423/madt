# Slip 20 - Question 1 - Reject Numbers

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/a" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="First number"/>
    <EditText android:id="@+id/b" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Second number"/>
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
        EditText a=findViewById(R.id.a), c=findViewById(R.id.b); TextView result=findViewById(R.id.result);
        findViewById(R.id.show).setOnClickListener(v->{ int x=Integer.parseInt(a.getText().toString()), y=Integer.parseInt(c.getText().toString()); if(x>20 && y>20) result.setText("Both numbers are greater than 20. Enter new numbers."); else result.setText("Numbers: "+x+" and "+y); });
    }
}
```

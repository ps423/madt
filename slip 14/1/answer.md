# Slip 14 - Question 1 - Factorial

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/num" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter number" android:inputType="number"/>
    <Button android:id="@+id/check" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Check"/>
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
        EditText num=findViewById(R.id.num); TextView result=findViewById(R.id.result);
        findViewById(R.id.check).setOnClickListener(v->{ int n=Integer.parseInt(num.getText().toString()); long f=1; for(int i=1;i<=n;i++) f*=i; result.setText("Factorial = "+f); });
    }
}
```

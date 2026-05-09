# Slip 19 - Question 2 - Option Menu Factorial Sum

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/num" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter number" android:inputType="number"/>
    <TextView android:id="@+id/result" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="20sp"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText num; TextView result;
    @Override protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_main); num=findViewById(R.id.num); result=findViewById(R.id.result); }
    @Override public boolean onCreateOptionsMenu(Menu menu){ menu.add("Find Factorial"); menu.add("Find Sum of Digits"); return true; }
    @Override public boolean onOptionsItemSelected(MenuItem item){
        int n=Integer.parseInt(num.getText().toString());
        if(item.getTitle().equals("Find Factorial")){ long f=1; for(int i=1;i<=n;i++) f*=i; result.setText("Factorial = "+f); }
        else { int sum=0; while(n>0){ sum+=n%10; n/=10; } result.setText("Sum = "+sum); }
        return true;
    }
}
```

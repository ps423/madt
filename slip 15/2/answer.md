# Slip 15 - Question 2 - Bank App

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/account" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Account Number"/>
    <EditText android:id="@+id/amount" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Amount"/>
    <Button android:id="@+id/create" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Create Balance"/>
    <Button android:id="@+id/deposit" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Deposit"/>
    <Button android:id="@+id/withdraw" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Withdraw"/>
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
    double balance=0;
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText amount=findViewById(R.id.amount); TextView result=findViewById(R.id.result);
        findViewById(R.id.create).setOnClickListener(v->{ balance=Double.parseDouble(amount.getText().toString()); result.setText("Balance = "+balance); });
        findViewById(R.id.deposit).setOnClickListener(v->{ balance+=Double.parseDouble(amount.getText().toString()); result.setText("Balance = "+balance); });
        findViewById(R.id.withdraw).setOnClickListener(v->{ double a=Double.parseDouble(amount.getText().toString()); if(a<=balance){ balance-=a; result.setText("Balance = "+balance); } else result.setText("Insufficient balance"); });
    }
}
```

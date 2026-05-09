# Slip 9 - Question 1 - Palindrome Number

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
    boolean isPalindrome(int n) {
        int temp = n, rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == n;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText num = findViewById(R.id.num);
        Button check = findViewById(R.id.check);
        TextView result = findViewById(R.id.result);

        check.setOnClickListener(v -> {
            int n = Integer.parseInt(num.getText().toString());
            String msg = isPalindrome(n) ? "Palindrome number" : "Not palindrome number";
            result.setText(msg);
        });
    }
}
```

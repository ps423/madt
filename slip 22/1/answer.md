# Slip 22 - Question 1 - Change Image

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <ImageView android:id="@+id/img" android:layout_width="match_parent" android:layout_height="300dp" android:src="@drawable/img1"/>
    <Button android:id="@+id/change" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Change Image"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean flag=false;
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        ImageView img=findViewById(R.id.img);
        findViewById(R.id.change).setOnClickListener(v->{ flag=!flag; img.setImageResource(flag ? R.drawable.img2 : R.drawable.img1); });
    }
}
```

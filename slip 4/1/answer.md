# Slip 4 - Question 1 - ImageSwitcher

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <ImageSwitcher android:id="@+id/switcher" android:layout_width="match_parent" android:layout_height="300dp"/>
    <Button android:id="@+id/next" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Next Image"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    int index=0;
    int[] images={R.drawable.img1, R.drawable.img2, R.drawable.img3};
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        ImageSwitcher sw=findViewById(R.id.switcher);
        sw.setFactory(() -> { ImageView iv=new ImageView(this); iv.setScaleType(ImageView.ScaleType.CENTER_CROP); return iv; });
        sw.setImageResource(images[index]);
        findViewById(R.id.next).setOnClickListener(v->{ index=(index+1)%images.length; sw.setImageResource(images[index]); });
    }
}
```

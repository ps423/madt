# Slip 6 - Question 2 - Google Map Search

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/location" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter location"/>
    <Button android:id="@+id/search" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Search"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText location=findViewById(R.id.location);
        findViewById(R.id.search).setOnClickListener(v->{
            Uri uri=Uri.parse("geo:0,0?q=" + Uri.encode(location.getText().toString()));
            Intent i=new Intent(Intent.ACTION_VIEW, uri);
            i.setPackage("com.google.android.apps.maps");
            startActivity(i);
        });
    }
}
```

# Slip 13 - Question 2 - ListView Operations

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/item" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Enter item"/>
    <Button android:id="@+id/insert" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Insert"/>
    <Button android:id="@+id/delete" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Delete"/>
    <Button android:id="@+id/search" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Search"/>
    <ListView android:id="@+id/list" android:layout_width="match_parent" android:layout_height="wrap_content"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText item=findViewById(R.id.item); ListView list=findViewById(R.id.list);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data); list.setAdapter(adapter);
        findViewById(R.id.insert).setOnClickListener(v->{ data.add(item.getText().toString()); adapter.notifyDataSetChanged(); });
        findViewById(R.id.delete).setOnClickListener(v->{ data.remove(item.getText().toString()); adapter.notifyDataSetChanged(); });
        findViewById(R.id.search).setOnClickListener(v->Toast.makeText(this, data.contains(item.getText().toString())?"Found":"Not found", Toast.LENGTH_SHORT).show());
    }
}
```

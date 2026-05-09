# Slip 16 - Question 2 - Player Name Intent

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <EditText android:id="@+id/player" android:layout_width="match_parent" android:layout_height="wrap_content" android:hint="Player name"/>
    <Button android:id="@+id/next" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Send"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        EditText player=findViewById(R.id.player);
        findViewById(R.id.next).setOnClickListener(v->{ Intent i=new Intent(this, SecondActivity.class); i.putExtra("player", player.getText().toString()); startActivity(i); });
    }
}
```

## activity_second.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <TextView android:id="@+id/name" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="24sp"/>
    <Button android:id="@+id/back" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="BACK"/>
</LinearLayout>
```

## SecondActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_second);
        TextView name=findViewById(R.id.name);
        name.setText(getIntent().getStringExtra("player"));
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}
```

## AndroidManifest.xml

```xml
<activity android:name=".SecondActivity" />
```

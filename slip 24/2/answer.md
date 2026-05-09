# Slip 24 - Question 2 - Car SQLite

## activity_main.xml

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">
    <Button android:id="@+id/insert" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Insert Records"/>
    <Button android:id="@+id/show" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Show Records"/>
    <TextView android:id="@+id/output" android:layout_width="match_parent" android:layout_height="wrap_content" android:textSize="16sp"/>
</LinearLayout>
```

## MainActivity.java

```java
package com.example.madt;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button insert = findViewById(R.id.insert);
        Button show = findViewById(R.id.show);
        TextView output = findViewById(R.id.output);

        db = openOrCreateDatabase("MADTDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Car(id INTEGER PRIMARY KEY, name TEXT, type TEXT, color TEXT)");

        insert.setOnClickListener(v -> {
            db.execSQL("DELETE FROM Car");
            db.execSQL("INSERT INTO Car VALUES(1,'Swift','Hatchback','White')");
            db.execSQL("INSERT INTO Car VALUES(2,'City','Sedan','Black')");
            db.execSQL("INSERT INTO Car VALUES(3,'Nexon','SUV','Blue')");
            db.execSQL("INSERT INTO Car VALUES(4,'Baleno','Hatchback','Red')");
            db.execSQL("INSERT INTO Car VALUES(5,'Creta','SUV','Silver')");
            Toast.makeText(this, "Records inserted", Toast.LENGTH_SHORT).show();
        });

        show.setOnClickListener(v -> {
            Cursor c = db.rawQuery("SELECT * FROM Car", null);
            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()) {
                sb.append("id: ").append(c.getString(0)).append("  ");
                sb.append("name: ").append(c.getString(1)).append("  ");
                sb.append("type: ").append(c.getString(2)).append("  ");
                sb.append("color: ").append(c.getString(3)).append("  ");
                sb.append("\n");
            }
            output.setText(sb.toString());
            c.close();
        });
    }
}
```

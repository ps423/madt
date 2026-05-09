# Slip 1 - Question 2 - Student SQLite

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
        db.execSQL("CREATE TABLE IF NOT EXISTS Student(roll_no INTEGER PRIMARY KEY, name TEXT, address TEXT, percentage REAL)");

        insert.setOnClickListener(v -> {
            db.execSQL("DELETE FROM Student");
            db.execSQL("INSERT INTO Student VALUES(1,'Amit','Pune',78.5)");
            db.execSQL("INSERT INTO Student VALUES(2,'Neha','Mumbai',82)");
            db.execSQL("INSERT INTO Student VALUES(3,'Ravi','Nashik',69)");
            db.execSQL("INSERT INTO Student VALUES(4,'Sara','Pune',91)");
            db.execSQL("INSERT INTO Student VALUES(5,'Om','Satara',74)");
            Toast.makeText(this, "Records inserted", Toast.LENGTH_SHORT).show();
        });

        show.setOnClickListener(v -> {
            Cursor c = db.rawQuery("SELECT * FROM Student", null);
            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()) {
                sb.append("roll_no: ").append(c.getString(0)).append("  ");
                sb.append("name: ").append(c.getString(1)).append("  ");
                sb.append("address: ").append(c.getString(2)).append("  ");
                sb.append("percentage: ").append(c.getString(3)).append("  ");
                sb.append("\n");
            }
            output.setText(sb.toString());
            c.close();
        });
    }
}
```

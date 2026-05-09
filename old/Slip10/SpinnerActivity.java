// Slip 10 - Q2: GUI using Spinner and Buttons
// File: SpinnerActivity.java

package com.example.spinnerapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class SpinnerActivity extends Activity {

    EditText etItem;
    Button btnAdd, btnRemove;
    Spinner spinner;
    TextView tvResponse;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        spinner = findViewById(R.id.spinner);
        tvResponse = findViewById(R.id.tvResponse);

        itemList = new ArrayList<>();
        itemList.add("Apple");
        itemList.add("Banana");
        itemList.add("Mango");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvResponse.setText("Selected: " + itemList.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnAdd.setOnClickListener(v -> {
            String item = etItem.getText().toString().trim();
            if (!item.isEmpty()) {
                itemList.add(item);
                adapter.notifyDataSetChanged();
                etItem.setText("");
                Toast.makeText(this, item + " added to spinner!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Enter an item first!", Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(v -> {
            int pos = spinner.getSelectedItemPosition();
            if (itemList.size() > 0) {
                String removed = itemList.get(pos);
                itemList.remove(pos);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, removed + " removed!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Spinner is empty!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/* activity_spinner.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="12dp">
        <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
            android:text="Enter Item: " android:textSize="16sp"/>
        <EditText android:id="@+id/etItem" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:hint="Apple"/>
    </LinearLayout>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="12dp">
        <Button android:id="@+id/btnAdd" android:layout_width="0dp"
            android:layout_weight="1" android:layout_height="wrap_content"
            android:text="Add to spinner"/>
        <Button android:id="@+id/btnRemove" android:layout_width="0dp"
            android:layout_weight="1" android:layout_height="wrap_content"
            android:text="Remove from spinner"/>
    </LinearLayout>

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="See Response Below" android:layout_marginBottom="8dp"/>

    <Spinner android:id="@+id/spinner"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:layout_marginBottom="12dp"/>

    <TextView android:id="@+id/tvResponse"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:textSize="16sp"/>

</LinearLayout>
*/

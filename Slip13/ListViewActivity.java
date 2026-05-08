// Slip 13 - Q2: ListView with Insert, Delete, Search operations
// File: ListViewActivity.java

package com.example.listviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import java.util.ArrayList;

public class ListViewActivity extends Activity {

    EditText etItem, etSearch;
    Button btnInsert, btnDelete, btnSearch;
    ListView listView;
    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        etItem = findViewById(R.id.etItem);
        etSearch = findViewById(R.id.etSearch);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnSearch = findViewById(R.id.btnSearch);
        listView = findViewById(R.id.listView);

        dataList = new ArrayList<>();
        dataList.add("Android");
        dataList.add("Java");
        dataList.add("Kotlin");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // Insert
        btnInsert.setOnClickListener(v -> {
            String item = etItem.getText().toString().trim();
            if (!item.isEmpty()) {
                dataList.add(item);
                adapter.notifyDataSetChanged();
                etItem.setText("");
                Toast.makeText(this, item + " inserted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Enter item to insert!", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete (selected item)
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            String removed = dataList.get(position);
            dataList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, removed + " deleted!", Toast.LENGTH_SHORT).show();
            return true;
        });

        // Delete by name
        btnDelete.setOnClickListener(v -> {
            String item = etItem.getText().toString().trim();
            if (dataList.remove(item)) {
                adapter.notifyDataSetChanged();
                Toast.makeText(this, item + " deleted!", Toast.LENGTH_SHORT).show();
                etItem.setText("");
            } else {
                Toast.makeText(this, item + " not found!", Toast.LENGTH_SHORT).show();
            }
        });

        // Search
        btnSearch.setOnClickListener(v -> {
            String searchTerm = etSearch.getText().toString().trim();
            if (searchTerm.isEmpty()) {
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
                listView.setAdapter(adapter);
                return;
            }
            ArrayList<String> filtered = new ArrayList<>();
            for (String item : dataList) {
                if (item.toLowerCase().contains(searchTerm.toLowerCase())) {
                    filtered.add(item);
                }
            }
            ArrayAdapter<String> filteredAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, filtered);
            listView.setAdapter(filteredAdapter);
            Toast.makeText(this, filtered.size() + " result(s) found!", Toast.LENGTH_SHORT).show();
        });
    }
}

/* activity_listview.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="ListView Demo" android:textSize="20sp" android:textStyle="bold"
        android:layout_marginBottom="12dp"/>

    <EditText android:id="@+id/etItem"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Enter item" android:layout_marginBottom="8dp"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="12dp">
        <Button android:id="@+id/btnInsert" android:text="Insert"
            android:layout_width="0dp" android:layout_weight="1" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnDelete" android:text="Delete"
            android:layout_width="0dp" android:layout_weight="1" android:layout_height="wrap_content"/>
    </LinearLayout>

    <EditText android:id="@+id/etSearch"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Search item" android:layout_marginBottom="8dp"/>

    <Button android:id="@+id/btnSearch"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Search" android:layout_marginBottom="12dp"/>

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="(Long press item to delete)" android:textSize="12sp"
        android:textStyle="italic" android:layout_marginBottom="8dp"/>

    <ListView android:id="@+id/listView"
        android:layout_width="match_parent" android:layout_height="match_parent"/>

</LinearLayout>
*/

// Slip 5 & 12 & 23 - Q2: Label Format with RadioButtons & CheckBoxes
// File: LabelFormatActivity.java

package com.example.labelformat;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.*;

public class LabelFormatActivity extends Activity {

    EditText etFirstName, etLastName;
    TextView tvLabel;
    RadioGroup rgColor;
    RadioButton rbRed, rbBlue, rbGreen;
    CheckBox cbBold, cbItalic, cbUnderline;
    Button btnDisplay, btnClear, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_format);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        tvLabel = findViewById(R.id.tvLabel);
        rgColor = findViewById(R.id.rgColor);
        rbRed = findViewById(R.id.rbRed);
        rbBlue = findViewById(R.id.rbBlue);
        rbGreen = findViewById(R.id.rbGreen);
        cbBold = findViewById(R.id.cbBold);
        cbItalic = findViewById(R.id.cbItalic);
        cbUnderline = findViewById(R.id.cbUnderline);
        btnDisplay = findViewById(R.id.btnDisplay);
        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);

        btnDisplay.setOnClickListener(v -> displayLabel());
        btnClear.setOnClickListener(v -> clearAll());
        btnExit.setOnClickListener(v -> finish());
    }

    void displayLabel() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            Toast.makeText(this, "Please enter both names!", Toast.LENGTH_SHORT).show();
            return;
        }

        String fullName = firstName + " " + lastName;

        // Apply color
        int selectedColorId = rgColor.getCheckedRadioButtonId();
        if (selectedColorId == R.id.rbRed) tvLabel.setTextColor(Color.RED);
        else if (selectedColorId == R.id.rbBlue) tvLabel.setTextColor(Color.BLUE);
        else if (selectedColorId == R.id.rbGreen) tvLabel.setTextColor(Color.GREEN);
        else tvLabel.setTextColor(Color.BLACK);

        // Apply style
        boolean bold = cbBold.isChecked();
        boolean italic = cbItalic.isChecked();

        if (bold && italic) tvLabel.setTypeface(null, Typeface.BOLD_ITALIC);
        else if (bold) tvLabel.setTypeface(null, Typeface.BOLD);
        else if (italic) tvLabel.setTypeface(null, Typeface.ITALIC);
        else tvLabel.setTypeface(null, Typeface.NORMAL);

        // Apply underline
        if (cbUnderline.isChecked()) {
            SpannableString ss = new SpannableString(fullName);
            ss.setSpan(new UnderlineSpan(), 0, ss.length(), 0);
            tvLabel.setText(ss);
        } else {
            tvLabel.setText(fullName);
        }
    }

    void clearAll() {
        etFirstName.setText("");
        etLastName.setText("");
        tvLabel.setText("");
        rgColor.clearCheck();
        cbBold.setChecked(false);
        cbItalic.setChecked(false);
        cbUnderline.setChecked(false);
    }
}

/* activity_label_format.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText android:id="@+id/etFirstName"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="First Name"/>

    <EditText android:id="@+id/etLastName"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="Last Name"/>

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Select Color:" android:textStyle="bold" android:layout_marginTop="8dp"/>

    <RadioGroup android:id="@+id/rgColor" android:orientation="horizontal"
        android:layout_width="match_parent" android:layout_height="wrap_content">
        <RadioButton android:id="@+id/rbRed" android:text="Red"/>
        <RadioButton android:id="@+id/rbBlue" android:text="Blue"/>
        <RadioButton android:id="@+id/rbGreen" android:text="Green"/>
    </RadioGroup>

    <CheckBox android:id="@+id/cbBold" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Bold"/>
    <CheckBox android:id="@+id/cbItalic" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Italic"/>
    <CheckBox android:id="@+id/cbUnderline" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:text="Underline"/>

    <TextView android:id="@+id/tvLabel"
        android:layout_width="match_parent" android:layout_height="60dp"
        android:textSize="22sp" android:gravity="center"
        android:background="#F0F0F0" android:layout_marginTop="12dp"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginTop="12dp">
        <Button android:id="@+id/btnDisplay" android:text="Display" android:layout_weight="1" android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnClear" android:text="Clear" android:layout_weight="1" android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnExit" android:text="Exit" android:layout_weight="1" android:layout_width="0dp" android:layout_height="wrap_content"/>
    </LinearLayout>

</LinearLayout>
*/

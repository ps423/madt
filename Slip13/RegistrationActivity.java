// Slip 13 - Q1: Registration Form with Validation
// File: RegistrationActivity.java

package com.example.registration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class RegistrationActivity extends Activity {

    EditText etName, etAddress, etMobile, etAge;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etMobile = findViewById(R.id.etMobile);
        etAge = findViewById(R.id.etAge);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> validateAndRegister());
    }

    void validateAndRegister() {
        String name = etName.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String age = etAge.getText().toString().trim();

        boolean valid = true;

        if (name.isEmpty()) {
            etName.setError("Name is required!");
            valid = false;
        } else if (name.length() < 3) {
            etName.setError("Name too short!");
            valid = false;
        }

        if (address.isEmpty()) {
            etAddress.setError("Address is required!");
            valid = false;
        }

        if (mobile.isEmpty()) {
            etMobile.setError("Mobile number is required!");
            valid = false;
        } else if (mobile.length() != 10) {
            etMobile.setError("Enter valid 10 digit mobile number!");
            valid = false;
        }

        if (age.isEmpty()) {
            etAge.setError("Age is required!");
            valid = false;
        } else {
            int ageVal = Integer.parseInt(age);
            if (ageVal < 18 || ageVal > 100) {
                etAge.setError("Age must be between 18 and 100!");
                valid = false;
            }
        }

        if (valid) {
            Toast.makeText(this, "Registration Successful!\nWelcome " + name, Toast.LENGTH_LONG).show();
            clearForm();
        }
    }

    void clearForm() {
        etName.setText("");
        etAddress.setText("");
        etMobile.setText("");
        etAge.setText("");
    }
}

/* activity_registration.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <TextView android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Registration Form" android:textSize="22sp" android:textStyle="bold"
        android:gravity="center" android:layout_marginBottom="20dp"/>

    <TableLayout android:layout_width="match_parent" android:layout_height="wrap_content">

        <TableRow>
            <TextView android:text="Name" android:padding="8dp"/>
            <EditText android:id="@+id/etName" android:layout_width="0dp"
                android:layout_weight="1" android:hint="Enter name"/>
        </TableRow>

        <TableRow>
            <TextView android:text="Address" android:padding="8dp"/>
            <EditText android:id="@+id/etAddress" android:layout_width="0dp"
                android:layout_weight="1" android:hint="Enter address"/>
        </TableRow>

        <TableRow>
            <TextView android:text="Mobile No." android:padding="8dp"/>
            <EditText android:id="@+id/etMobile" android:layout_width="0dp"
                android:layout_weight="1" android:hint="Enter mobile" android:inputType="phone"/>
        </TableRow>

        <TableRow>
            <TextView android:text="Age" android:padding="8dp"/>
            <EditText android:id="@+id/etAge" android:layout_width="0dp"
                android:layout_weight="1" android:hint="Enter age" android:inputType="number"/>
        </TableRow>

    </TableLayout>

    <Button android:id="@+id/btnRegister"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="Register" android:layout_marginTop="20dp"/>

</LinearLayout>
*/

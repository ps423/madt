// Slip 14 & 25 - Q2: Login Form - Username == Password check
// File: LoginValidationActivity.java

package com.example.loginvalidation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class LoginValidationActivity extends Activity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty()) {
                etUsername.setError("Enter username!");
                return;
            }
            if (password.isEmpty()) {
                etPassword.setError("Enter password!");
                return;
            }

            if (username.equals(password)) {
                Toast.makeText(this, "Login Successful...", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();
            }
        });
    }
}

/* activity_login.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="24dp" android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Login Form" android:textSize="26sp" android:textStyle="bold"
        android:layout_marginBottom="30dp"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="12dp">
        <TextView android:text="UserName" android:layout_width="100dp" android:layout_height="wrap_content"/>
        <EditText android:id="@+id/etUsername" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:hint="UserName"/>
    </LinearLayout>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginBottom="24dp">
        <TextView android:text="Password" android:layout_width="100dp" android:layout_height="wrap_content"/>
        <EditText android:id="@+id/etPassword" android:layout_width="match_parent"
            android:layout_height="wrap_content" android:hint="Password" android:inputType="textPassword"/>
    </LinearLayout>

    <Button android:id="@+id/btnLogin"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="LOGIN"/>

</LinearLayout>
*/

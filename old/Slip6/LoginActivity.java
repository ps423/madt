// Slip 6 - Q1: Login Form with Validation
// File: LoginActivity.java

package com.example.loginform;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText etEmail, etPassword;
    Button btnLogin;
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

        btnLogin.setOnClickListener(v -> validateAndLogin());

        tvSignUp.setOnClickListener(v ->
            Toast.makeText(LoginActivity.this, "Sign Up clicked!", Toast.LENGTH_SHORT).show()
        );
    }

    void validateAndLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean valid = true;

        if (email.isEmpty()) {
            etEmail.setError("Email is required!");
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter valid email!");
            valid = false;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required!");
            valid = false;
        } else if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters!");
            valid = false;
        }

        if (valid) {
            Toast.makeText(this, "Login Successful! Welcome: " + email, Toast.LENGTH_LONG).show();
        }
    }
}

/* activity_login.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="LOGIN" android:textSize="28sp" android:textStyle="bold"
        android:layout_marginBottom="32dp"/>

    <EditText android:id="@+id/etEmail"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="EMAIL" android:inputType="textEmailAddress"
        android:layout_marginBottom="16dp"/>

    <EditText android:id="@+id/etPassword"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:hint="PASSWORD" android:inputType="textPassword"
        android:layout_marginBottom="24dp"/>

    <Button android:id="@+id/btnLogin"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        android:text="LOGIN" android:layout_marginBottom="16dp"/>

    <TextView android:id="@+id/tvSignUp"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Not a member? Sign Up now."
        android:textColor="#0000FF"/>

</LinearLayout>
*/

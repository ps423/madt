// Slip 15 - Q2: Simple Bank Application
// File: BankActivity.java

package com.example.bankapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class BankActivity extends Activity {

    EditText etAccountNumber, etAccountType, etBalance, etAmount;
    RadioButton rbChecking, rbSavings;
    Button btnCreate, btnCheckBalance, btnDeposit, btnWithdraw;
    TextView tvResult;

    double currentBalance = 0;
    boolean accountCreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        etAccountNumber = findViewById(R.id.etAccountNumber);
        etAccountType = findViewById(R.id.etAccountType);
        etBalance = findViewById(R.id.etBalance);
        etAmount = findViewById(R.id.etAmount);
        rbChecking = findViewById(R.id.rbChecking);
        rbSavings = findViewById(R.id.rbSavings);
        btnCreate = findViewById(R.id.btnCreate);
        btnCheckBalance = findViewById(R.id.btnBalance);
        btnDeposit = findViewById(R.id.btnDeposit);
        btnWithdraw = findViewById(R.id.btnWithdraw);
        tvResult = findViewById(R.id.tvResult);

        btnCreate.setOnClickListener(v -> {
            String accNo = etAccountNumber.getText().toString().trim();
            String balance = etBalance.getText().toString().trim();
            if (accNo.isEmpty() || balance.isEmpty()) {
                Toast.makeText(this, "Enter account number and initial balance!", Toast.LENGTH_SHORT).show();
                return;
            }
            currentBalance = Double.parseDouble(balance);
            accountCreated = true;
            String type = rbChecking.isChecked() ? "Checking" : "Savings";
            tvResult.setText("Account Created!\nAcc No: " + accNo + "\nType: " + type +
                    "\nBalance: ₹" + currentBalance);
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();
        });

        btnCheckBalance.setOnClickListener(v -> {
            if (!accountCreated) { Toast.makeText(this, "Create account first!", Toast.LENGTH_SHORT).show(); return; }
            tvResult.setText("Current Balance: ₹" + currentBalance);
        });

        btnDeposit.setOnClickListener(v -> {
            if (!accountCreated) { Toast.makeText(this, "Create account first!", Toast.LENGTH_SHORT).show(); return; }
            String amtStr = etAmount.getText().toString().trim();
            if (amtStr.isEmpty()) { Toast.makeText(this, "Enter amount!", Toast.LENGTH_SHORT).show(); return; }
            double amount = Double.parseDouble(amtStr);
            if (amount <= 0) { Toast.makeText(this, "Enter valid amount!", Toast.LENGTH_SHORT).show(); return; }
            currentBalance += amount;
            tvResult.setText("Deposited: ₹" + amount + "\nNew Balance: ₹" + currentBalance);
            etAmount.setText("");
        });

        btnWithdraw.setOnClickListener(v -> {
            if (!accountCreated) { Toast.makeText(this, "Create account first!", Toast.LENGTH_SHORT).show(); return; }
            String amtStr = etAmount.getText().toString().trim();
            if (amtStr.isEmpty()) { Toast.makeText(this, "Enter amount!", Toast.LENGTH_SHORT).show(); return; }
            double amount = Double.parseDouble(amtStr);
            if (amount <= 0) { Toast.makeText(this, "Enter valid amount!", Toast.LENGTH_SHORT).show(); return; }
            if (amount > currentBalance) { Toast.makeText(this, "Insufficient balance!", Toast.LENGTH_SHORT).show(); return; }
            currentBalance -= amount;
            tvResult.setText("Withdrawn: ₹" + amount + "\nNew Balance: ₹" + currentBalance);
            etAmount.setText("");
        });
    }
}

/* activity_bank.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical" android:padding="16dp">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:text="Simple Bank Application" android:textSize="20sp" android:textStyle="bold"
        android:layout_marginBottom="16dp"/>

    <EditText android:id="@+id/etAccountNumber" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="ACCOUNT NUMBER" android:inputType="number"/>

    <EditText android:id="@+id/etAccountType" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="ACCOUNT TYPE"/>

    <EditText android:id="@+id/etBalance" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="BALANCE" android:inputType="numberDecimal"/>

    <RadioGroup android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginTop="8dp">
        <RadioButton android:id="@+id/rbChecking" android:text="Checking" android:checked="true"/>
        <RadioButton android:id="@+id/rbSavings" android:text="Savings"/>
    </RadioGroup>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginTop="8dp">
        <Button android:id="@+id/btnCreate" android:text="Create" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnBalance" android:text="Balance" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
    </LinearLayout>

    <EditText android:id="@+id/etAmount" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:hint="Enter amount" android:inputType="numberDecimal"/>

    <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
        android:orientation="horizontal" android:layout_marginTop="8dp">
        <Button android:id="@+id/btnDeposit" android:text="Deposit" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
        <Button android:id="@+id/btnWithdraw" android:text="Withdraw" android:layout_weight="1"
            android:layout_width="0dp" android:layout_height="wrap_content"/>
    </LinearLayout>

    <TextView android:id="@+id/tvResult" android:layout_width="match_parent"
        android:layout_height="wrap_content" android:textSize="16sp"
        android:layout_marginTop="16dp" android:background="#E8F5E9" android:padding="8dp"/>

</LinearLayout>
*/

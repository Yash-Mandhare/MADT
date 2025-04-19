package com.example.bankapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private double balance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCheck = findViewById(R.id.btnCheck);
        Button btnDeposit = findViewById(R.id.btnDeposit);
        Button btnWithdraw = findViewById(R.id.btnWithdraw);
        Button btnExit = findViewById(R.id.btnExit);

        btnCheck.setOnClickListener(v -> {
            Toast.makeText(this, "Current Balance: ₹" + balance, Toast.LENGTH_SHORT).show();
        });

        btnDeposit.setOnClickListener(v -> showInputDialog("Deposit Amount", true));

        btnWithdraw.setOnClickListener(v -> showInputDialog("Withdraw Amount", false));

        btnExit.setOnClickListener(v -> {
            Toast.makeText(this, "Thank you for using My Bank App!", Toast.LENGTH_SHORT).show();
            finish(); // closes the app
        });
    }

    private void showInputDialog(String title, boolean isDeposit) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String value = input.getText().toString();
            if (value.isEmpty()) {
                Toast.makeText(this, "Amount cannot be empty!", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(value);

            if (isDeposit) {
                balance += amount;
                Toast.makeText(this, "Deposited ₹" + amount, Toast.LENGTH_SHORT).show();
            } else {
                if (amount > balance) {
                    Toast.makeText(this, "Insufficient balance!", Toast.LENGTH_SHORT).show();
                } else {
                    balance -= amount;
                    Toast.makeText(this, "Withdrew ₹" + amount, Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}

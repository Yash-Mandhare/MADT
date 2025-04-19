package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        View.OnClickListener operation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = num1.getText().toString();
                String val2 = num2.getText().toString();

                if (val1.isEmpty() || val2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                double n1 = Double.parseDouble(val1);
                double n2 = Double.parseDouble(val2);
                double result = 0;

                if (v.getId() == R.id.btnAdd) {
                    result = n1 + n2;
                    Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.btnSub) {
                    result = n1 - n2;
                    Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.btnMul) {
                    result = n1 * n2;
                    Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.btnDiv) {
                    if (n2 == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = n1 / n2;
                    Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnAdd.setOnClickListener(operation);
        btnSub.setOnClickListener(operation);
        btnMul.setOnClickListener(operation);
        btnDiv.setOnClickListener(operation);
    }
}

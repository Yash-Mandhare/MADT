package com.example.yourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button submitButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        submitButton = findViewById(R.id.submitButton);
        resultText = findViewById(R.id.resultText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1Str = number1.getText().toString();
                String num2Str = number2.getText().toString();

                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);

                if (num1 > 20 && num2 > 20) {
                    Toast.makeText(MainActivity.this, "Both numbers are greater than 20. Try again.", Toast.LENGTH_SHORT).show();
                    number1.setText("");
                    number2.setText("");
                } else {
                    resultText.setText("You entered:\nFirst number: " + num1 + "\nSecond number: " + num2);
                }
            }
        });
    }
}

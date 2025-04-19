package com.example.perfectnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText numberInput;
    Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = numberInput.getText().toString();

                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    if (isPerfectNumber(number)) {
                        Toast.makeText(MainActivity.this, number + " is a Perfect Number", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, number + " is NOT a Perfect Number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        return sum == num;
    }
}

package com.example.factorialsum;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText numberInput;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberInput = findViewById(R.id.numberInput);
        resultText = findViewById(R.id.resultText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu); // Make sure this XML exists
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String inputStr = numberInput.getText().toString().trim();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return true;
        }

        int number = Integer.parseInt(inputStr);

        if (item.getItemId() == R.id.menu_factorial) {
            resultText.setText("Factorial: " + factorial(number));
            return true;
        } else if (item.getItemId() == R.id.menu_sum_digits) {
            resultText.setText("Sum of Digits: " + sumOfDigits(number));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private long factorial(int n) {
        if (n < 0) return -1;
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private int sumOfDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

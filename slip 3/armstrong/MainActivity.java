package com.example.armstrong;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    Button checkButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        checkButton = findViewById(R.id.checkButton);
        resultText = findViewById(R.id.resultText);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputNumber.getText().toString();

                if (input.isEmpty()) {
                    resultText.setText("Please enter a number");
                    return;
                }

                int num = Integer.parseInt(input);
                int sum = 0, temp = num;
                int digits = input.length();

                while (temp > 0) {
                    int digit = temp % 10;
                    sum += Math.pow(digit, digits);
                    temp /= 10;
                }

                if (sum == num) {
                    resultText.setText(num + " is an Armstrong number");
                } else {
                    resultText.setText(num + " is not an Armstrong number");
                }
            }
        });
    }
}

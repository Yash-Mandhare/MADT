package com.example.numberoperations;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;
    RadioGroup radioGroup;
    Button btnCheck;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        radioGroup = findViewById(R.id.radioGroup);
        btnCheck = findViewById(R.id.btnCheck);
        resultText = findViewById(R.id.resultText);

        btnCheck.setOnClickListener(v -> {
            String input = numberInput.getText().toString();

            if (input.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                return;
            }

            int number = Integer.parseInt(input);
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == R.id.radioOddEven) {
                resultText.setText(number % 2 == 0 ? "Even" : "Odd");

            } else if (selectedId == R.id.radioPositiveNegative) {
                if (number > 0) {
                    resultText.setText("Positive");
                } else if (number < 0) {
                    resultText.setText("Negative");
                } else {
                    resultText.setText("Zero");
                }

            } else if (selectedId == R.id.radioSquare) {
                resultText.setText("Square: " + (number * number));

            } else {
                Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

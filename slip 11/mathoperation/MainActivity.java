package com.example.mathoperation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnPower, btnAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.editTextNumber1);
        number2 = findViewById(R.id.editTextNumber2);
        btnPower = findViewById(R.id.btnPower);
        btnAverage = findViewById(R.id.btnAverage);

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndSendResult("power");
            }
        });

        btnAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndSendResult("average");
            }
        });
    }

    private void calculateAndSendResult(String operation) {
        String num1Str = number1.getText().toString();
        String num2Str = number2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result;

            if (operation.equals("power")) {
                result = Math.pow(num1, num2);
            } else {
                result = (num1 + num2) / 2;
            }

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("result", result);
            intent.putExtra("operation", operation);
            startActivity(intent);
        }
    }
}

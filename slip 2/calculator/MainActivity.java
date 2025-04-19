package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    String current = "", operator = "";
    double first = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                current += b.getText().toString();
                resultText.setText(current);
            }
        };

        int[] numberButtonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(numberClickListener);
        }

        findViewById(R.id.btnAdd).setOnClickListener(opClick);
        findViewById(R.id.btnSub).setOnClickListener(opClick);
        findViewById(R.id.btnMul).setOnClickListener(opClick);
        findViewById(R.id.btnDiv).setOnClickListener(opClick);

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            current = "";
            operator = "";
            first = 0;
            resultText.setText("0");
        });

        findViewById(R.id.btnEqual).setOnClickListener(v -> {
            if (!current.isEmpty()) {
                double second = Double.parseDouble(current);
                double result = 0;
                switch (operator) {
                    case "+": result = first + second; break;
                    case "-": result = first - second; break;
                    case "*": result = first * second; break;
                    case "/": result = second != 0 ? first / second : 0; break;
                }
                resultText.setText(String.valueOf(result));
                current = String.valueOf(result);
                operator = "";
            }
        });
    }

    View.OnClickListener opClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            if (!current.isEmpty()) {
                first = Double.parseDouble(current);
                operator = b.getText().toString();
                current = "";
            }
        }
    };
}

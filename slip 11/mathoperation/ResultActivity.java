package com.example.mathoperation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = findViewById(R.id.resultText);

        double result = getIntent().getDoubleExtra("result", 0.0);
        String operation = getIntent().getStringExtra("operation");

        resultText.setText("Result of " + operation + " is: " + result);
    }
}

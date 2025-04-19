package com.example.factorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText editNumber;
    Button btnCalculate;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = findViewById(R.id.editNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numStr = editNumber.getText().toString().trim();

                if (numStr.isEmpty()) {
                    textResult.setText("Please enter a number.");
                    return;
                }

                int num = Integer.parseInt(numStr);
                if (num < 0) {
                    textResult.setText("Please enter a non-negative number.");
                    return;
                }

                long fact = 1;
                for (int i = 1; i <= num; i++) {
                    fact *= i;
                }

                textResult.setText("Factorial of " + num + " is: " + fact);
            }
        });
    }
}

package com.example.palindromechecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText getnum;
    Button checkBtn;
    TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getnum = findViewById(R.id.getnum);
        checkBtn = findViewById(R.id.checkBtn);
        resultLabel = findViewById(R.id.resultLabel);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numStr = getnum.getText().toString();

                if (numStr.isEmpty()) {
                    resultLabel.setText("Please enter a number.");
                    return;
                }

                // Check for palindrome
                String reversed = new StringBuilder(numStr).reverse().toString();
                if (numStr.equals(reversed)) {
                    resultLabel.setText(numStr + " is a Palindrome");
                } else {
                    resultLabel.setText(numStr + " is NOT a Palindrome");
                }
            }
        });
    }
}

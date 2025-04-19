package com.example.phonenumber;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phoneInput;
    Button validateButton;
    TextView validationResult;

    String[] validAreaCodes = {"040", "041", "050", "0400", "044"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // This will only work if R is generated

        phoneInput = findViewById(R.id.phoneInput);
        validateButton = findViewById(R.id.validateButton);
        validationResult = findViewById(R.id.validationResult);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phoneInput.getText().toString().trim();

                if (number.isEmpty()) {
                    validationResult.setText("Please enter a phone number.");
                    return;
                }

                boolean isValid = false;

                for (String areaCode : validAreaCodes) {
                    if (number.startsWith(areaCode)) {
                        int totalLength = number.length();
                        if (totalLength >= 6 && totalLength <= 8) {
                            isValid = true;
                        }
                        break;
                    }
                }

                if (isValid) {
                    validationResult.setText("Valid phone number.");
                } else {
                    validationResult.setText("Invalid phone number format.");
                }
            }
        });
    }
}

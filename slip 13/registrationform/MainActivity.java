package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit, addressEdit, mobileEdit, ageEdit;
    Button registerBtn;
    TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.editName);
        addressEdit = findViewById(R.id.editAddress);
        mobileEdit = findViewById(R.id.editMobile);
        ageEdit = findViewById(R.id.editAge);
        registerBtn = findViewById(R.id.btnRegister);
        resultLabel = findViewById(R.id.resultLabel);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString().trim();
                String address = addressEdit.getText().toString().trim();
                String mobile = mobileEdit.getText().toString().trim();
                String ageStr = ageEdit.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    nameEdit.setError("Name is required");
                    return;
                }

                if (TextUtils.isEmpty(address)) {
                    addressEdit.setError("Address is required");
                    return;
                }

                if (mobile.length() != 10 || !mobile.matches("\\d+")) {
                    mobileEdit.setError("Enter valid 10-digit mobile number");
                    return;
                }

                if (TextUtils.isEmpty(ageStr)) {
                    ageEdit.setError("Age is required");
                    return;
                }

                int age = Integer.parseInt(ageStr);
                if (age < 18) {
                    ageEdit.setError("You must be at least 18 years old");
                    return;
                }

                // If all validations pass
                resultLabel.setText("Registration Successful!\nWelcome, " + name + "!");
            }
        });
    }
}

package com.example.stringoperations;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    RadioGroup optionsGroup;
    Button btnOperate;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        optionsGroup = findViewById(R.id.radioGroup);
        btnOperate = findViewById(R.id.btnOperate);
        resultText = findViewById(R.id.resultText);

        btnOperate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                int selectedId = optionsGroup.getCheckedRadioButtonId();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter some text", Toast.LENGTH_SHORT).show();
                    return;
                }

                String result = "";
                if (selectedId == R.id.radioUpper) {
                    result = input.toUpperCase();
                } else if (selectedId == R.id.radioLower) {
                    result = input.toLowerCase();
                } else if (selectedId == R.id.radioLeft5) {
                    result = input.length() >= 5 ? input.substring(0, 5) : input;
                } else if (selectedId == R.id.radioRight5) {
                    result = input.length() >= 5 ? input.substring(input.length() - 5) : input;
                } else {
                    Toast.makeText(MainActivity.this, "Select an option", Toast.LENGTH_SHORT).show();
                    return;
                }


                resultText.setText("Result: " + result);
            }
        });
    }
}

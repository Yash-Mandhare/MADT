package com.example.stringcasetoggle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnUpper, btnLower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnUpper = findViewById(R.id.btnUpper);
        btnLower = findViewById(R.id.btnLower);

        btnUpper.setOnClickListener(v -> {
            String input = etInput.getText().toString();
            if (!input.isEmpty()) {
                Toast.makeText(MainActivity.this, input.toUpperCase(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter a string", Toast.LENGTH_SHORT).show();
            }
        });

        btnLower.setOnClickListener(v -> {
            String input = etInput.getText().toString();
            if (!input.isEmpty()) {
                Toast.makeText(MainActivity.this, input.toLowerCase(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter a string", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

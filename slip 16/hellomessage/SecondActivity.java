package com.example.hellomessage;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMessage = findViewById(R.id.txtMessage);

        String message = getIntent().getStringExtra("message");
        txtMessage.setText("Received: " + message);
    }
}

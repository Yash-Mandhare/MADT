package com.example.formattextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    TextView messageText;
    RadioGroup colorGroup;
    CheckBox cbBold, cbItalic, cbUnderline;
    Button btnShow, btnClear, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        messageText = findViewById(R.id.messageText);
        colorGroup = findViewById(R.id.colorGroup);
        cbBold = findViewById(R.id.cbBold);
        cbItalic = findViewById(R.id.cbItalic);
        cbUnderline = findViewById(R.id.cbUnderline);
        btnShow = findViewById(R.id.btnShow);
        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);

        btnShow.setOnClickListener(v -> showMessage());
        btnClear.setOnClickListener(v -> clearAll());
        btnExit.setOnClickListener(v -> finish());
    }

    private void showMessage() {
        String name = nameInput.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = "Hello, " + name + "!";
        SpannableString spanText = new SpannableString(message);

        if (cbBold.isChecked()) {
            spanText.setSpan(new StyleSpan(Typeface.BOLD), 0, message.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (cbItalic.isChecked()) {
            spanText.setSpan(new StyleSpan(Typeface.ITALIC), 0, message.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (cbUnderline.isChecked()) {
            spanText.setSpan(new UnderlineSpan(), 0, message.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // Set color based on radio selection
        int selectedColorId = colorGroup.getCheckedRadioButtonId();
        if (selectedColorId == R.id.rbRed) {
            messageText.setTextColor(Color.RED);
        } else if (selectedColorId == R.id.rbBlue) {
            messageText.setTextColor(Color.BLUE);
        } else if (selectedColorId == R.id.rbGreen) {
            messageText.setTextColor(Color.GREEN);
        } else {
            messageText.setTextColor(Color.BLACK);
        }

        messageText.setText(spanText);
    }

    private void clearAll() {
        nameInput.setText("");
        messageText.setText("");
        cbBold.setChecked(false);
        cbItalic.setChecked(false);
        cbUnderline.setChecked(false);
        colorGroup.clearCheck();
    }
}

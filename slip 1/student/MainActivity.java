package com.example.student;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        db = new DatabaseHelper(this);

        Cursor c = db.getAllStudents();
        StringBuilder sb = new StringBuilder();

        while (c.moveToNext()) {
            sb.append("Roll No: ").append(c.getInt(0))
                    .append("\nName: ").append(c.getString(1))
                    .append("\nAddress: ").append(c.getString(2))
                    .append("\nPercentage: ").append(c.getFloat(3))
                    .append("\n\n");
        }

        textView.setText(sb.toString());
    }
}

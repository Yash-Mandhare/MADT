package com.example.googlemap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etLocation;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLocation = findViewById(R.id.etLocation);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(view -> {
            String location = etLocation.getText().toString().trim();
            if (!location.isEmpty()) {
                Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // Fallback if Maps is not installed
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(location))));
                }
            }
        });
    }
}

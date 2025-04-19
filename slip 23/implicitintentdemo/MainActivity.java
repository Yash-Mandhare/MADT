package com.example.implicitintentdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnOpenWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenWebsite = findViewById(R.id.btnOpenWebsite);

        btnOpenWebsite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.sayiwebbook.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            intent.setPackage("com.android.chrome"); // Force Chrome

            // Check if Chrome is available
            PackageManager packageManager = getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                // Fallback: use any browser
                Intent fallbackIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(fallbackIntent);
            }
        });
    }
}

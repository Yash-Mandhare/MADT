package com.example.emaildemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Dummy file creation (optional)
        File file = new File(getFilesDir(), "example.txt");
        if (!file.exists()) {
            try {
                file.createNewFile(); // Creates the file if it doesn't exist
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Uri uri = FileProvider.getUriForFile(this,
                getPackageName() + ".fileprovider", file);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"someone@example.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
        intent.putExtra(Intent.EXTRA_TEXT, "This is a test email with attachment.");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        startActivity(Intent.createChooser(intent, "Send email..."));
        finish();
    }
}

package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button startButton;
    TextView statusText;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        startButton = findViewById(R.id.startButton);
        statusText = findViewById(R.id.statusText);

        progressBar.setVisibility(View.GONE);  // Hide initially

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus = 0;
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
                statusText.setText("Loading...");

                // Simulate loading
                new Thread(new Runnable() {
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 1;
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    statusText.setText("Progress: " + progressStatus + "%");
                                }
                            });
                            try {
                                Thread.sleep(50); // Simulate time-consuming task
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                statusText.setText("Task Completed!");
                            }
                        });
                    }
                }).start();
            }
        });
    }
}

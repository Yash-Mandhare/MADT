package com.example.lifecycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate");
        Log.d(TAG, "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume");
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause");
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart");
        Log.d(TAG, "onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
        Log.d(TAG, "onDestroy called");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

package com.example.lightbulbtoggle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView bulbImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        bulbImage = findViewById(R.id.bulbImage);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bulbImage.setImageResource(R.drawable.bulb_on);
                } else {
                    bulbImage.setImageResource(R.drawable.bulb_off);
                }
            }
        });
    }
}

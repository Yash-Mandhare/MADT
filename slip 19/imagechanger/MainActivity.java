package com.example.imagechanger;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnChangeImage;
    boolean isImageOne = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnChangeImage = findViewById(R.id.btnChangeImage);

        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isImageOne) {
                    imageView.setImageResource(R.drawable.image2);
                } else {
                    imageView.setImageResource(R.drawable.image1);
                }
                isImageOne = !isImageOne;
            }
        });
    }
}

package com.nabin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class MainActivity extends AppCompatActivity {
    FlipperLayout flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        flipper = (FlipperLayout) findViewById(R.id.flipper);
        setLayout();

        CardView medicine_alert = findViewById(R.id.medicine_alert);
        medicine_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Alarmhome.class));
            }
        });

        CardView emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Emergency.class));
            }
        });

    }

    private void setLayout() {
        int[] url = new int[]{
                R.drawable.birhospital,
                R.drawable.cancerhospital,
                R.drawable.bmi,
        };

        for (int i = 0; i < 3; i++) {
            FlipperView view = new FlipperView(getBaseContext());
            view.setImageUrl(String.valueOf(url[i]))
                    .setDescription("Image" + (i + 1));

            flipper.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    Toast.makeText(MainActivity.this, "" + (flipper.getCurrentPagePosition() + 1), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


}

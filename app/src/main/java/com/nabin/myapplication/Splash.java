package com.nabin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        Thread th= new Thread(){

            @Override
            public void run() {

                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent obj = new Intent(Splash.this, MainActivity.class);
                    startActivity(obj);
                };


            }
        };
        th.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

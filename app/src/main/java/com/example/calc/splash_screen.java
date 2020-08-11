package com.example.calc;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class splash_screen extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EasySplashScreen config = new EasySplashScreen(splash_screen.this)
                    .withFullScreen()
                    .withTargetActivity(MainActivity.class)
                    .withSplashTimeOut(3500)
                    .withBackgroundResource(android.R.color.background_light)
                    .withFooterText("Learn and Share")
                    .withBeforeLogoText("Calculator")
                    .withLogo(R.mipmap.logo)
                    .withAfterLogoText("Where 10 multiply 10 yields 101");
            config.getFooterTextView().setTextSize(20);
            config.getBeforeLogoTextView().setTextSize(19);
            config.getAfterLogoTextView().setTextSize(20);

            //finally create the view
            View easySplashScreenView = config.create();
            setContentView(easySplashScreenView);
        }


}


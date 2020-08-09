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
                    .withFooterText("Calculator")
                    .withBeforeLogoText("Learn and Share")
                    .withLogo(R.drawable.ic_baseline_collections_bookmark_24)
                    .withAfterLogoText("This is Just A Calculation App");
            config.getFooterTextView().setTextSize(20);
            config.getBeforeLogoTextView().setTextSize(19);

            //finally create the view
            View easySplashScreenView = config.create();
            setContentView(easySplashScreenView);
        }


}


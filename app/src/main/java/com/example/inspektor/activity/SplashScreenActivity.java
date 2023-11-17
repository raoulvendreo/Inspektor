package com.example.inspektor.activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inspektor.databinding.ActivitySplashScreenBinding;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding splashScreenBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        new Handler().postDelayed(this::checkPermission, 1000);

        splashScreenBinding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(splashScreenBinding.getRoot());


        new Handler().postDelayed(()->{
            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
            finish();
        }, 1200);
        // Bisa panggil API di sini selama aplikasi munculin SplashScreen


    }

    private void checkPermission() {
        //
    }

}

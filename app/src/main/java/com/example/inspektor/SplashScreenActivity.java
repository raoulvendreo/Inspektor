package com.example.inspektor;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        new Handler().postDelayed(this::checkPermission, 1000);


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

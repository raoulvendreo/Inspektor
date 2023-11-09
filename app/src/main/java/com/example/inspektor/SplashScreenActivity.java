package com.example.inspektor;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(this::checkPermission, 1000);

        // Bisa panggil API di sini selama aplikasi munculin SplashScreen

        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
        finish();
    }

    private void checkPermission() {
        //
    }

}

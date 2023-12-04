package com.example.inspektor.activity;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inspektor.databinding.ActivitySplashScreenBinding;
import com.example.inspektor.model.AuthGetLoggedUserRequest;
import com.example.inspektor.retrofit.ApiClient;
import com.example.inspektor.room.RoomDb;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding splashScreenBinding;
    ApiClient apiClient;
    RoomDb roomDb;

    private static final String TOKEN_SHARED_PREFS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashScreenBinding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(splashScreenBinding.getRoot());



        roomDb = RoomDb.getInstance(getApplication());

        SharedPreferences sharedPreferences = this.getSharedPreferences(TOKEN_SHARED_PREFS, MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        if (token.isEmpty()){

            Log.e(TAG, "Tidak ada Token!");

            new Handler().postDelayed(()->{
                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                finish();
            }, 1000);
        } else {
            /*apiClient = new ApiClient();
            apiClient.retrofit(getApplicationContext());

            apiClient.getUserData(new AuthGetLoggedUserRequest(token));*/

            Log.e(TAG, "Token Valid! Tokennya adalah: " + token);

            startActivity(new Intent(SplashScreenActivity.this, VehicleDashboardActivity.class));
            finish();
        }

//        Toast.makeText(this, "currentToken: " + token, Toast.LENGTH_SHORT).show();
//        new Handler().postDelayed(this::checkPermission, 1000);
        // Bisa panggil API di sini selama aplikasi munculin SplashScreen
    }

    private void checkPermission() {
        //
    }
}

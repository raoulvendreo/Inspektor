package com.example.inspektor.activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.inspektor.databinding.ActivityLoginBinding;
import com.example.inspektor.model.AuthGetLoggedUserRequest;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthToken;
import com.example.inspektor.retrofit.ApiClient;
import com.example.inspektor.retrofit.ApiInterface;

import retrofit2.Call;


public class LoginActivity extends AppCompatActivity {

    private static final String TOKEN_SHARED_PREFS = "";
    private ActivityLoginBinding loginBinding;
    private ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiClient = new ApiClient();
        apiClient.retrofit(getApplicationContext());

        initializeView();
    }

    private void initializeView() {
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());

        loginBinding.buttonLogin.setOnClickListener(view ->
                OnClickedLoginButton());
    }

    private void OnClickedLoginButton() {
            //Retrieve entered userAD & passAD
            String userAD = loginBinding.editTextUsername.getText().toString();
            String passAD = loginBinding.editTextPassword.getText().toString();

            String selectedDomain = "";

            if (!loginBinding.rdioDomainLonsum.isChecked() && !loginBinding.rdioDomainIndofood.isChecked()){
                Toast.makeText(this, "Pilih salah satu domain!", Toast.LENGTH_SHORT).show();
            }

            if (!userAD.isEmpty() && !passAD.isEmpty() &&
                    (loginBinding.rdioDomainLonsum.isChecked() || loginBinding.rdioDomainIndofood.isChecked())) {

                if (loginBinding.rdioDomainIndofood.isChecked()){
                    selectedDomain = "indofood";
                }

                if (loginBinding.rdioDomainLonsum.isChecked()){
                    selectedDomain = "lonsum";
                }

                SharedPreferences sharedPreferences = this.getSharedPreferences(TOKEN_SHARED_PREFS, MODE_PRIVATE);
                String token = sharedPreferences.getString("token", "");

                Log.e(TAG, "Proses getToken berlangsung... ");

                apiClient.getToken(new AuthRequest(userAD, passAD, selectedDomain));



                /*if (!token.isEmpty()){
                    apiClient.getUserData(new AuthGetLoggedUserRequest(token));

                    startActivity(new Intent(LoginActivity.this, VehicleDashboardActivity.class));
                    new Handler().postDelayed(()->{
                        Toast.makeText(this, "Loading... ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, VehicleDashboardActivity.class));
                        finish();
                    }, 1000);
                }*/
//                startActivity(new Intent(LoginActivity.this, VehicleDashboardActivity.class));
//                finish();
            }


            if (userAD.isEmpty()) {
                // User AD belum disii
                loginBinding.editTextUsername.setError("User AD wajib diisi!");
                loginBinding.editTextUsername.requestFocus();

            } else if (passAD.isEmpty()) {
                // Pass AD belum diisi
                loginBinding.editTextPassword.setError("Password wajib diisi!");
                loginBinding.editTextPassword.requestFocus();
            }
    }

}
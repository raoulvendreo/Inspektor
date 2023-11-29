package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.inspektor.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();
        OnClickedLoginButton();
    }

    private void initializeView() {
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());
    }

    private void OnClickedLoginButton() {
        loginBinding.buttonLogin.setOnClickListener(view -> {

            //Retrieve entered userAD & passAD
            String userAD = loginBinding.editTextUsername.getText().toString();
            String passAD = loginBinding.editTextPassword.getText().toString();


            //Authentication userAD & passAD
            if (userAD.equals("Inspektor") && passAD.equals("123456")) {
                // Successful login
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(LoginActivity.this, VehicleDashboardActivity.class));
                finish();
            }
            if (userAD.isEmpty()) {
                // User AD belum disii
                loginBinding.editTextUsername.setError("User AD wajib diisi!");
                loginBinding.editTextUsername.requestFocus();

            } else if (passAD.isEmpty()) {
                // Pass AD belum diisi
                loginBinding.editTextPassword.setError("Password wajib diisi!");
                loginBinding.editTextPassword.requestFocus();

            } else if (!userAD.equals("Inspektor")) {

                loginBinding.editTextUsername.setError("User AD tidak terdaftar!");
                loginBinding.editTextUsername.requestFocus();

            } else if (!passAD.equals("123456")) {

                loginBinding.editTextPassword.setError("Password anda salah!");
                loginBinding.editTextPassword.requestFocus();
            }
        });
    }
}
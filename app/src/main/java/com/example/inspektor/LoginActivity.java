package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.inspektor.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding loginBinding;

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

    private void OnClickedLoginButton(){
        loginBinding.buttonLogin.setOnClickListener(view -> {

            //Retrieve entered userAD & passAD
            String userAD = loginBinding.editTextUsername.toString();
            String passAD = loginBinding.editTextPassword.toString();

            //Authentication userAD & passAD
            if (userAD.equals("Inspektor") && passAD.equals("123456")) {
                // Successful login
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(LoginActivity.this, VehicleDashboardActivity.class));
                finish();
            } else if (userAD.isEmpty()){
                // User AD belum disii
                Toast.makeText(this, "User AD harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (passAD.isEmpty()){
                // Pass AD belum diisi
                Toast.makeText(this, "Password harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                // Failed login
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
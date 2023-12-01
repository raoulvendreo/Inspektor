package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.inspektor.databinding.ActivityLoginBinding;
import com.example.inspektor.model.AuthRequest;
import com.example.inspektor.model.AuthToken;
import com.example.inspektor.retrofit.ApiClient;
import com.example.inspektor.retrofit.ApiInterface;

import retrofit2.Call;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginBinding;
    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiClient = new ApiClient();

        initializeView();

        addListenerOnRadioButton();

        OnClickedLoginButton();
    }

    private void addListenerOnRadioButton() {


    }

    private void initializeView() {
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());
    }

    private void OnClickedLoginButton() {



        loginBinding.buttonLogin.setOnClickListener(view -> {

            apiClient.retrofit(getApplicationContext());

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

                apiClient.getToken(new AuthRequest(userAD, passAD, selectedDomain));

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

            } /*else if (!userAD.equals("Inspektor")) {

                loginBinding.editTextUsername.setError("User AD tidak terdaftar!");
                loginBinding.editTextUsername.requestFocus();

            } else if (!passAD.equals("123456")) {

                loginBinding.editTextPassword.setError("Password anda salah!");
                loginBinding.editTextPassword.requestFocus();
            }*/
        });
    }

}
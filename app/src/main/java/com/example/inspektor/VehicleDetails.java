package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inspektor.databinding.ActivityVehicleDetailsBinding;

public class VehicleDetails extends AppCompatActivity {

    ActivityVehicleDetailsBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();

    }

    private void initializeView() {
        detailsBinding = ActivityVehicleDetailsBinding.inflate(getLayoutInflater());
        setContentView(detailsBinding.getRoot());
    }
}
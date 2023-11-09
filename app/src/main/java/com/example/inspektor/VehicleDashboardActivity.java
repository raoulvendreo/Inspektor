package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;

public class VehicleDashboardActivity extends AppCompatActivity {

    ActivityVehicleDashboardBinding dashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();

    }

    private void initializeView() {
        dashboardBinding = ActivityVehicleDashboardBinding.inflate(getLayoutInflater());
        setContentView(dashboardBinding.getRoot());
    }
}
package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;
import com.example.inspektor.databinding.ActivityVehicleInspectionBinding;

public class VehicleInspectionActivity extends AppCompatActivity {

    ActivityVehicleInspectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();

    }

    private void initializeView() {
        binding = ActivityVehicleInspectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
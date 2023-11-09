package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;
import com.example.inspektor.databinding.ActivityVehicleInspectionBinding;

public class VehicleInspectionActivity extends AppCompatActivity {

    ActivityVehicleInspectionBinding inspectionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();

    }

    private void initializeView() {
        inspectionBinding = ActivityVehicleInspectionBinding.inflate(getLayoutInflater());
        setContentView(inspectionBinding.getRoot());
    }
}
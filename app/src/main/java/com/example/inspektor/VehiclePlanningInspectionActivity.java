package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inspektor.databinding.ActivityVehiclePlanningInspectionBinding;

public class VehiclePlanningInspectionActivity extends AppCompatActivity {

    ActivityVehiclePlanningInspectionBinding planningInspectionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();
    }

    private void initializeView() {
        planningInspectionBinding = ActivityVehiclePlanningInspectionBinding.inflate(getLayoutInflater());
        setContentView(planningInspectionBinding.getRoot());
    }
}
package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.inspektor.R;
import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;
import com.example.inspektor.databinding.ActivityVehicleInspectionBinding;

public class VehicleInspectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityVehicleInspectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();

    }

    private void initializeView() {
        binding = ActivityVehicleInspectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> adapterVehicleType = ArrayAdapter.createFromResource(this, R.array.vehicle_types, android.R.layout.simple_spinner_item);
        adapterVehicleType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerVehicleType.setAdapter(adapterVehicleType);
        binding.spinnerVehicleType.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterCondition = ArrayAdapter.createFromResource(this,R.array.vehicle_condition, android.R.layout.simple_spinner_item);
        adapterCondition.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCondition.setAdapter(adapterCondition);
        binding.spinnerCondition.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterVehiclePart = ArrayAdapter.createFromResource(this,R.array.vehicle_part, android.R.layout.simple_spinner_item);
        adapterVehiclePart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerDamagePart.setAdapter(adapterVehiclePart);
        binding.spinnerDamagePart.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
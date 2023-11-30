package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.inspektor.OnVehicleTypeClickListener;
import com.example.inspektor.R;
import com.example.inspektor.VehicleCategoryAdapter;
import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;
import com.example.inspektor.model.VehicleCategoryListItem;

import java.util.ArrayList;
import java.util.List;

public class VehicleDashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnVehicleTypeClickListener {

    private ActivityVehicleDashboardBinding binding;
    private RecyclerView recyclerView;
    private VehicleCategoryAdapter categoryAdapter;
    private List<VehicleCategoryListItem> itemList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();
        showVehicleCatalog();
    }

    private void showVehicleCatalog() {
    recyclerView = binding.recyclerViewDashboard;
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    //data dummy
        itemList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            VehicleCategoryListItem listItem = new VehicleCategoryListItem(
                    "VEHICLE TYPE " + (i+1), "TOTAL: " + i+6 , "Baik: " + i+2, "Rusak: " + i+2, "Not Yet Inspected: " + i +2, null
            );
            itemList.add(listItem);
        }

    categoryAdapter = new VehicleCategoryAdapter(itemList, this, this);
    recyclerView.setAdapter(categoryAdapter);

    }

    private void initializeView() {
        binding = ActivityVehicleDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.business_area, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(this);

        binding.startInspectionButton.setOnClickListener(view -> {
            Intent startInspect = new Intent(VehicleDashboardActivity.this, VehiclePlanningInspectionActivity.class);
            startActivity(startInspect);
        });

        binding.logoutButton.setOnClickListener(view -> {
            Intent logoutIntent = new Intent(VehicleDashboardActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onVehicleTypeClick(VehicleCategoryListItem itemList) {
        startActivity(new Intent(VehicleDashboardActivity.this,VehicleDetailsActivity.class)
                .putExtra("data", itemList));

    }
}
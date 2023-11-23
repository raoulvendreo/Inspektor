package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.inspektor.OnPlanningInspectClickListener;
import com.example.inspektor.R;
import com.example.inspektor.VehiclePlanningInspectionAdapter;
import com.example.inspektor.databinding.ActivityVehiclePlanningInspectionBinding;
import com.example.inspektor.model.VehiclePlanningInspectionListItem;

import java.util.ArrayList;
import java.util.List;

public class VehiclePlanningInspectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnPlanningInspectClickListener {

    private ActivityVehiclePlanningInspectionBinding binding;
    private RecyclerView recyclerView;
    private VehiclePlanningInspectionAdapter planningInspectionAdapter;
    private List<VehiclePlanningInspectionListItem> planningInspectionListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();

    }

    private void initializeView() {
        binding = ActivityVehiclePlanningInspectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.business_area, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(this);

        showPlanningInspectionTaskList();
    }
    private void showPlanningInspectionTaskList() {
        recyclerView = binding.recyclerViewPlanInspectList;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //generating data dummy
        planningInspectionListItems = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            VehiclePlanningInspectionListItem listItem = new VehiclePlanningInspectionListItem(
                    "Running Account: BK8533CG","Business Area: 3550","Status: 1","Planning Date: 20-11-23","Inspected At: 04.10.2023"
            );
            planningInspectionListItems.add(listItem);
        }
        planningInspectionAdapter = new VehiclePlanningInspectionAdapter(planningInspectionListItems, this, this);
        recyclerView.setAdapter(planningInspectionAdapter);

        //Terakhir dikerjakan di 22-10-23, selanjutnya bikin isi VehiclePlanningInspectionAdapter

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPlanningInspectClick(VehiclePlanningInspectionListItem planInspectItem) {
        startActivity(new Intent(VehiclePlanningInspectionActivity.this, VehicleInspectionActivity.class)
                /*.putExtra("data", planInspectItem)*/);

    }
}
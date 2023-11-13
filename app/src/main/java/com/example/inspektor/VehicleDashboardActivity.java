package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class VehicleDashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityVehicleDashboardBinding dashboardBinding;
    RecyclerView recyclerView;
    VehicleCategoryAdapter categoryAdapter;
    List<VehicleCategoryListItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();
        showVehicleCatalog();
    }

    private void showVehicleCatalog() {
    recyclerView = dashboardBinding.recyclerViewDashboard;
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    //data dummy
        itemList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            VehicleCategoryListItem listItem = new VehicleCategoryListItem(
                    "Heavy Equipment Type " + (i+1), "Baik: " + i+7, "Rusak: " + i+1,null
            );
            itemList.add(listItem);
        }

    categoryAdapter = new VehicleCategoryAdapter(itemList, this);
    recyclerView.setAdapter(categoryAdapter);

    }

    private void initializeView() {
        dashboardBinding = ActivityVehicleDashboardBinding.inflate(getLayoutInflater());
        setContentView(dashboardBinding.getRoot());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.business_area, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        adapter.setAdapter(adapter);
        dashboardBinding.spinner.setAdapter(adapter);
        dashboardBinding.spinner.setOnItemSelectedListener(this);

        dashboardBinding.startInspectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInspect = new Intent(VehicleDashboardActivity.this, VehicleInspectionActivity.class);
                startActivity(startInspect);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
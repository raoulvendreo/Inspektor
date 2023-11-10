package com.example.inspektor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class VehicleDashboardActivity extends AppCompatActivity {

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
    }
}
package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.inspektor.OnVehicleTypeClickListener;
import com.example.inspektor.R;
import com.example.inspektor.VehicleCategoryAdapter;
import com.example.inspektor.databinding.ActivityVehicleDashboardBinding;
import com.example.inspektor.model.AuthGetLoggedUserRequest;
import com.example.inspektor.model.VehicleCategoryListItem;
import com.example.inspektor.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class VehicleDashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnVehicleTypeClickListener {

    private static final String TOKEN_SHARED_PREFS = "";
    private ActivityVehicleDashboardBinding binding;
    private RecyclerView recyclerView;
    private VehicleCategoryAdapter categoryAdapter;
    private List<VehicleCategoryListItem> itemList;

    private ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiClient = new ApiClient();
        apiClient.retrofit(getApplicationContext());

        syncData();

        initializeView();
        showVehicleCatalog();
    }

    private void syncData() {

        SharedPreferences sharedPreferences = this.getSharedPreferences(TOKEN_SHARED_PREFS, MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        //Mau coba panggil semua data dari server via Retrofit di sini
        //Terakhir di 4-12-23 sedang mencoba koding method untuk ambil semua data dari server lalu dimasukkan ke RoomDB

        // UNTUK GET USER LOGIN DATA
//        apiClient.getUserData(new AuthGetLoggedUserRequest(token));


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
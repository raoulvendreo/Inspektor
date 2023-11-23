package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.inspektor.OnVehicleTypeClickListener;
import com.example.inspektor.VehicleDetailsAdapter;
import com.example.inspektor.databinding.ActivityVehicleDetailsBinding;
import com.example.inspektor.model.VehicleCategoryListItem;
import com.example.inspektor.model.VehicleDetailsListItem;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetailsActivity extends AppCompatActivity implements OnVehicleTypeClickListener {

    private ActivityVehicleDetailsBinding binding;
    private VehicleCategoryListItem categoryListItem;
    private List<VehicleDetailsListItem> detailsListItem;
    private RecyclerView recyclerView;
    private VehicleDetailsAdapter detailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        InitializeView();
    }

    private void InitializeView() {
        binding = ActivityVehicleDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categoryListItem = (VehicleCategoryListItem) getIntent().getSerializableExtra("data");

        assert categoryListItem != null;
        binding.tvVehicleCategory.setText(categoryListItem.getVehicleCategory());
        binding.tvConditionGood.setText(categoryListItem.getConditionGood());
        binding.tvConditionBroken.setText(categoryListItem.getConditionBad());
        binding.tvNotYetInspected.setText(categoryListItem.getNotYetInspected());

        //use Glide to bind the Image

        showVehicleDetails();
    }

    private void showVehicleDetails(){
        recyclerView = binding.recyclerViewDetails;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //generating data dummy
        detailsListItem = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            VehicleDetailsListItem detailsListItem1 = new VehicleDetailsListItem(
                     "Running Account: BK8533CG","Business Area: 355" + i,"Location: 112.LT.23.57.199","Status: 1","Last Inspected: 04.10.2023"
            );
            detailsListItem.add(detailsListItem1);
        }
        detailsAdapter = new VehicleDetailsAdapter(detailsListItem,this);
        recyclerView.setAdapter(detailsAdapter);
    }


    @Override
    public void onVehicleTypeClick(VehicleCategoryListItem itemList) {

    }
}
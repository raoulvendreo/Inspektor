package com.example.inspektor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inspektor.R;
import com.example.inspektor.databinding.ActivityVehicleDetailsBinding;
import com.example.inspektor.model.VehicleCategoryListItem;

public class VehicleDetailsActivity extends AppCompatActivity implements OnVehicleTypeClickListener{

    ActivityVehicleDetailsBinding binding;
    VehicleCategoryListItem listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        InitializeView();

        listItem = (VehicleCategoryListItem) getIntent().getSerializableExtra("data");

        assert listItem != null;
        binding.tvVehicleCategory.setText(listItem.getVehicleCategory());
        binding.tvConditionGood.setText(listItem.getConditionGood());
        binding.tvConditionBroken.setText(listItem.getConditionBad());
        binding.tvNotYetInspected.setText(listItem.getNotYetInspected());

        //use Glide to bind the Image

    }

    private void InitializeView() {
            binding = ActivityVehicleDetailsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());


    }


    @Override
    public void onVehicleTypeClick(VehicleCategoryListItem itemList) {

    }
}
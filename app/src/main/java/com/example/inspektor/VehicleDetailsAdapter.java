package com.example.inspektor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inspektor.databinding.ListVehicleDetailsBinding;
import com.example.inspektor.model.VehicleDetailsListItem;

import java.util.List;

public class VehicleDetailsAdapter extends RecyclerView.Adapter<VehicleDetailsAdapter.DetailsViewHolder> {

    private List<VehicleDetailsListItem> itemList;
    private Context context;

    public VehicleDetailsAdapter(List<VehicleDetailsListItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }


    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListVehicleDetailsBinding binding = ListVehicleDetailsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        holder.tv_runAcc.setText(itemList.get(position).getRunningAccount());
        holder.tv_bArea.setText(itemList.get(position).getBusinessArea());
        holder.tv_latLong.setText(itemList.get(position).getLocation());
        holder.tv_stts.setText(itemList.get(position).getStatus());
        holder.tv_lastInspec.setText(itemList.get(position).getLastInspec());

        //Ini bagian terakhir yang dikerjain pada tanggal 21-11-23

        //sedang kembangin recyclerView & adapter untuk VehicleDetailsActivity

        //selanjutnya populate isi VehicleDetails lalu lanjut mengerjakan Vehicle Planning Inspection
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_runAcc, tv_bArea, tv_latLong, tv_stts, tv_lastInspec;
        CardView cardView;
        public DetailsViewHolder(@NonNull ListVehicleDetailsBinding binding) {
            super(binding.getRoot());
            tv_runAcc = binding.tvRunAcc;
            tv_bArea = binding.tvBA;
            tv_latLong = binding.tvLatlong;
            tv_stts = binding.tvStts;
            tv_lastInspec = binding.tvLastInspec;
            cardView = binding.listVehicleDetailsContainer;

        }
    }
}

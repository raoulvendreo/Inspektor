package com.example.inspektor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inspektor.databinding.ListVehicleCategoryBinding;
import com.example.inspektor.model.VehicleCategoryListItem;

import java.util.List;

public class VehicleCategoryAdapter extends RecyclerView.Adapter<VehicleCategoryAdapter.ViewHolder> {

    private List<VehicleCategoryListItem> itemList;
    private Context context;

    private OnVehicleTypeClickListener listener;

    public VehicleCategoryAdapter(List<VehicleCategoryListItem> itemList, Context context, OnVehicleTypeClickListener listener) {
        this.itemList = itemList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListVehicleCategoryBinding binding = ListVehicleCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvVCat.setText(itemList.get(position).getVehicleCategory());
        holder.tvCondGood.setText(itemList.get(position).getConditionGood());
        holder.tvCondBad.setText(itemList.get(position).getConditionBad());
        holder.tvNotYetInspected.setText(itemList.get(position).getNotYetInspected());

        Glide.with(context)
                .load(itemList.get(position).getImgVehicle())
                .placeholder(R.drawable.placeholder_img)
                .into(holder.imgVCat);

//        holder.bind(itemList.get(position), listener);

        holder.cardView.setOnClickListener(view -> {
            listener.onVehicleTypeClick(itemList.get(position));
            /*Intent i = new Intent(context, VehicleDetailsActivity.class);
            context.startActivity(i);*/
        });

        /*holder.cardView.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), VehicleDetailsFragment.class);
            view.getContext().startActivity(i);
        });*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvVCat, tvCondGood, tvCondBad, tvNotYetInspected;
        ImageView imgVCat;
        CardView cardView;

        public ViewHolder(@NonNull ListVehicleCategoryBinding binding) {
            super(binding.getRoot());

            tvVCat = binding.tvVehicleCategory;
            tvCondGood = binding.tvConditionGood;
            tvCondBad = binding.tvConditionBroken;
            tvNotYetInspected = binding.tvNotYetInspected;
            imgVCat = binding.imgVehicleCat;
            cardView = binding.listVehicleCategoryContainer;
        }

        public void bind(VehicleCategoryListItem vehicleCategoryListItem, OnVehicleTypeClickListener listener) {


        }
    }
}

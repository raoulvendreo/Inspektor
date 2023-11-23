package com.example.inspektor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inspektor.databinding.ListPlanningInspectionBinding;
import com.example.inspektor.model.VehiclePlanningInspectionListItem;

import java.util.List;

public class VehiclePlanningInspectionAdapter extends RecyclerView.Adapter<VehiclePlanningInspectionAdapter.PlanningInspectionViewHolder> {

    private List<VehiclePlanningInspectionListItem> planningInspectionListItems;
    private Context context;
    private OnPlanningInspectClickListener listener;
    public VehiclePlanningInspectionAdapter(List<VehiclePlanningInspectionListItem> planningInspectionListItems, Context context, OnPlanningInspectClickListener listener) {
        this.planningInspectionListItems = planningInspectionListItems;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanningInspectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListPlanningInspectionBinding binding = ListPlanningInspectionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PlanningInspectionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanningInspectionViewHolder holder, int position) {

        holder.tv_runAcc.setText(planningInspectionListItems.get(position).getRunningAccount());
        holder.tv_bArea.setText(planningInspectionListItems.get(position).getBusinessArea());
        holder.tv_status.setText(planningInspectionListItems.get(position).getStatus());
        holder.tv_planningDate.setText(planningInspectionListItems.get(position).getPlanningDate());
        holder.tv_inspectDate.setText(planningInspectionListItems.get(position).getInspectDate());

        holder.cardView.setOnClickListener(view -> {
            /*listener.onPlanningInspectClick(planningInspectionListItems.get(position));*/


        });
    }

    @Override
    public int getItemCount() {
        return planningInspectionListItems.size();
    }

    public class PlanningInspectionViewHolder extends RecyclerView.ViewHolder{

        TextView tv_runAcc, tv_bArea, tv_status, tv_planningDate, tv_inspectDate;
        CardView cardView;

        public PlanningInspectionViewHolder(ListPlanningInspectionBinding binding) {
            super(binding.getRoot());

            tv_runAcc = binding.tvRunAcc;
            tv_bArea = binding.tvBA;
            tv_status = binding.tvStts;
            tv_planningDate = binding.tvPlanningDate;
            tv_inspectDate = binding.tvInspecDate;
            cardView = binding.listPlanningInspectionContainer;

        }
    }
}

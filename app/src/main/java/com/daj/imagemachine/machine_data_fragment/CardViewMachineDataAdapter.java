package com.daj.imagemachine.machine_data_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daj.imagemachine.R;
import com.daj.imagemachine.dbhelpers.MachineHelper;
import com.daj.imagemachine.models.Machine;

import java.util.List;

public class CardViewMachineDataAdapter extends RecyclerView.Adapter<CardViewMachineDataAdapter.CardViewViewHolder> {
    private Context context;
    private List<Machine> machineList;
    private MachineHelper machineHelper;
    private List<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<Machine> mMachineList) {
        this.machineList = mMachineList;
        notifyDataSetChanged();
    }

    public CardViewMachineDataAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        holder.macId.setText(String.valueOf(getMachineList().get(position).getMachineID()));
        holder.macName.setText(getMachineList().get(position).getMachineName());
        holder.macType.setText(getMachineList().get(position).getMachineType());
        holder.macQRCode.setText(getMachineList().get(position).getMachineQRCode());
        holder.macLastMTDate.setText(getMachineList().get(position).getLastMaintenanceDate());
    }

    @Override
    public int getItemCount() {
        return getMachineList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView macId, macName, macType, macQRCode, macLastMTDate;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            macId = itemView.findViewById(R.id.tv_mac_id);
            macName = itemView.findViewById(R.id.tv_mac_name);
            macType = itemView.findViewById(R.id.tv_mac_type);
            macQRCode = itemView.findViewById(R.id.tv_mac_qrcode);
            macLastMTDate = itemView.findViewById(R.id.tv_mac_lmtdate);
        }
    }
}

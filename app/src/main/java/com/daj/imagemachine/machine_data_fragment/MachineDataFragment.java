package com.daj.imagemachine.machine_data_fragment;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.daj.imagemachine.R;
import com.daj.imagemachine.custom_classes.ItemClickSupport;
import com.daj.imagemachine.dbhelpers.MachineHelper;
import com.daj.imagemachine.detail_activity.DetailActivity;
import com.daj.imagemachine.models.Machine;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MachineDataFragment extends Fragment {

    private List<Machine> machineList;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private CardViewMachineDataAdapter cvMachineDataAdapter;
    private Context context;
    public MachineDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_machine_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // do things right after the fragment is completely inflated
        context = getContext();
        recyclerView = view.findViewById(R.id.rv_machine_data_list);
        progressBar = view.findViewById(R.id.progressBar);
        recyclerView.setHasFixedSize(true);
        showLoading(true);
        cvMachineDataAdapter = new CardViewMachineDataAdapter(context);
        cvMachineDataAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        // code to implement viewmodel goes here

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("MACHINE", machineList.get(position));
                startActivity(intent);
            }
        });


    }

    private void showLoading(Boolean state) {
        if(state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}

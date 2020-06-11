package com.daj.imagemachine.machine_data_fragment;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daj.imagemachine.dbhelpers.DBContract;
import com.daj.imagemachine.dbhelpers.MachineHelper;
import com.daj.imagemachine.models.Machine;

import java.util.ArrayList;
import java.util.List;

public class MachineDataViewModel extends ViewModel {

    private MutableLiveData<List<Machine>> machineList;
    private MachineHelper machineHelper;

    public MachineDataViewModel() {

    }


    public LiveData<List<Machine>> getMachines() {
        if(machineList == null) {
            machineList = new MutableLiveData<>();

        }
        return machineList;
    }

    private void loadMachine() {
        machineHelper.open();
        ArrayList<Machine> mMachineList = new ArrayList<>();
        try {
            Cursor cursor = machineHelper.getAllItem(DBContract.machineTableColums.COLUMN_MAC_ID, "DESC");
            if (cursor.moveToFirst()) {
                do {
                    Machine machine = new Machine();
                    machine.setMachineID(cursor.getInt(cursor.getColumnIndex(DBContract.machineTableColums.COLUMN_MAC_ID)));
                    machine.setMachineName(cursor.getString(cursor.getColumnIndex(DBContract.machineTableColums.COLUMN_MAC_NAME)));
                    machine.setMachineType(cursor.getString(cursor.getColumnIndex(DBContract.machineTableColums.COLUMN_MAC_TYPE)));
                    machine.setMachineQRCode(cursor.getString(cursor.getColumnIndex(DBContract.machineTableColums.COLUMN_MAC_CODE)));
                    machine.setLastMaintenanceDate(cursor.getString(cursor.getColumnIndex(DBContract.machineTableColums.COLUMN_MAC_LAST_MT_DATE)));
                    mMachineList.add(machine);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        machineList.setValue(mMachineList);
    }
}

package com.daj.imagemachine.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Machine implements Parcelable {

    private int machineID;
    private String machineName;
    private String machineType;
    private String machineQRCode;
    private String lastMaintenanceDate;

    public Machine() {

    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineQRCode() {
        return machineQRCode;
    }

    public void setMachineQRCode(String machineQRCode) {
        this.machineQRCode = machineQRCode;
    }

    public String getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(String lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    private Machine(Parcel in) {
        machineID = in.readInt();
        machineName = in.readString();
        machineType = in.readString();
        machineQRCode = in.readString();
        lastMaintenanceDate = in.readString();
    }

    public static final Creator<Machine> CREATOR = new Creator<Machine>() {
        @Override
        public Machine createFromParcel(Parcel in) {
            return new Machine(in);
        }

        @Override
        public Machine[] newArray(int size) {
            return new Machine[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(machineID);
        dest.writeString(machineName);
        dest.writeString(machineType);
        dest.writeString(machineQRCode);
        dest.writeString(lastMaintenanceDate);
    }
}

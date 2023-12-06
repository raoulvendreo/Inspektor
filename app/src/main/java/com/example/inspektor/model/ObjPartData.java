package com.example.inspektor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjPartData implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("obj_part")
    @Expose
    private String objPart;

    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    @SerializedName("zinspec_vehicletype_id")
    @Expose
    private int zinspecVehicletypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjPart() {
        return objPart;
    }

    public void setObjPart(String objPart) {
        this.objPart = objPart;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getZinspecVehicletypeId() {
        return zinspecVehicletypeId;
    }

    public void setZinspecVehicletypeId(int zinspecVehicletypeId) {
        this.zinspecVehicletypeId = zinspecVehicletypeId;
    }
}

package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Inspec_VehicType")
public class VehicleTypeEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "VEHICLE_TYPE")
    private String vehicleType;

    @ColumnInfo(name = "CODE")
    private Integer code;

    @ColumnInfo(name = "OBJ_PART")
    private String objPart;

    public VehicleTypeEntity(){

    }

    @Ignore
    public VehicleTypeEntity(Integer id, String vehicleType, Integer code, String objPart) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.code = code;
        this.objPart = objPart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getObjPart() {
        return objPart;
    }

    public void setObjPart(String objPart) {
        this.objPart = objPart;
    }
}

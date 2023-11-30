package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Inspec_ObjPart")
public class ObjPartEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "OBJ_PART")
    private String objPart;

    @ColumnInfo(name = "VEHICLE")
    private String vehicle;

    @ColumnInfo(name = "HEAVY_VEHICLE")
    private String heavyVehicle;

    @ColumnInfo(name = "POWER")
    private String power;

    @ColumnInfo(name = "WATER_PUMP")
    private String waterPump;

    @ColumnInfo(name = "MESIN_PENUNJANG")
    private String mesinPenunjang;

    public ObjPartEntity(){

    }

    @Ignore
    public ObjPartEntity(Integer id, String objPart, String vehicle, String heavyVehicle, String power, String waterPump, String mesinPenunjang) {
        this.id = id;
        this.objPart = objPart;
        this.vehicle = vehicle;
        this.heavyVehicle = heavyVehicle;
        this.power = power;
        this.waterPump = waterPump;
        this.mesinPenunjang = mesinPenunjang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjPart() {
        return objPart;
    }

    public void setObjPart(String objPart) {
        this.objPart = objPart;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getHeavyVehicle() {
        return heavyVehicle;
    }

    public void setHeavyVehicle(String heavyVehicle) {
        this.heavyVehicle = heavyVehicle;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWaterPump() {
        return waterPump;
    }

    public void setWaterPump(String waterPump) {
        this.waterPump = waterPump;
    }

    public String getMesinPenunjang() {
        return mesinPenunjang;
    }

    public void setMesinPenunjang(String mesinPenunjang) {
        this.mesinPenunjang = mesinPenunjang;
    }
}

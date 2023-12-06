package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "VehicleTypeTable")
public class VecTypeEntity implements Serializable {

    @PrimaryKey @NonNull
    @ColumnInfo(name = "id")
    private int vecTypeId;

    @ColumnInfo(name = "vehicle_type")
    private String vecType;

    @ColumnInfo(name = "code")
    private String vecTypeCode;

    @ColumnInfo(name = "obj_part")
    private String vecTypeObjPart;

    public VecTypeEntity(){

    }

    @Ignore
    public VecTypeEntity(int vecTypeId, String vecType, String vecTypeCode, String vecTypeObjPart) {
        this.vecTypeId = vecTypeId;
        this.vecType = vecType;
        this.vecTypeCode = vecTypeCode;
        this.vecTypeObjPart = vecTypeObjPart;
    }

    public int getVecTypeId() {
        return vecTypeId;
    }

    public void setVecTypeId(int vecTypeId) {
        this.vecTypeId = vecTypeId;
    }

    public String getVecType() {
        return vecType;
    }

    public void setVecType(String vecType) {
        this.vecType = vecType;
    }

    public String getVecTypeCode() {
        return vecTypeCode;
    }

    public void setVecTypeCode(String vecTypeCode) {
        this.vecTypeCode = vecTypeCode;
    }

    public String getVecTypeObjPart() {
        return vecTypeObjPart;
    }

    public void setVecTypeObjPart(String vecTypeObjPart) {
        this.vecTypeObjPart = vecTypeObjPart;
    }
}

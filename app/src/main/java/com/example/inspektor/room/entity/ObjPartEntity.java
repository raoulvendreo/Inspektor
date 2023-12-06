package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ObjPartTable")
public class ObjPartEntity implements Serializable {

    @PrimaryKey @NonNull
    @ColumnInfo(name = "id")
    private int objPartId;

    @ColumnInfo(name = "obj_part")
    private String objPartName;

    @ColumnInfo(name = "vehicle_type")
    private String objPartVehicleType;

    @ColumnInfo(name = "zinspec_vehicletype_id")
    private int objPartZinspecVehicletypeId;

    public ObjPartEntity(){

    }

    @Ignore
    public ObjPartEntity(int objPartId, String objPartName, String objPartVehicleType, int objPartZinspecVehicletypeId) {
        this.objPartId = objPartId;
        this.objPartName = objPartName;
        this.objPartVehicleType = objPartVehicleType;
        this.objPartZinspecVehicletypeId = objPartZinspecVehicletypeId;
    }

    public int getObjPartId() {
        return objPartId;
    }

    public void setObjPartId(int objPartId) {
        this.objPartId = objPartId;
    }

    public String getObjPartName() {
        return objPartName;
    }

    public void setObjPartName(String objPartName) {
        this.objPartName = objPartName;
    }

    public String getObjPartVehicleType() {
        return objPartVehicleType;
    }

    public void setObjPartVehicleType(String objPartVehicleType) {
        this.objPartVehicleType = objPartVehicleType;
    }

    public int getObjPartZinspecVehicletypeId() {
        return objPartZinspecVehicletypeId;
    }

    public void setObjPartZinspecVehicletypeId(int objPartZinspecVehicletypeId) {
        this.objPartZinspecVehicletypeId = objPartZinspecVehicletypeId;
    }
}

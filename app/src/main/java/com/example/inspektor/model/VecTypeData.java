package com.example.inspektor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VecTypeData implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("vehicle_type")
    @Expose
    private String vecTypeName;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("obj_part")
    @Expose
    private String obj_part;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVecTypeName() {
        return vecTypeName;
    }

    public void setVecType(String vecTypeName) {
        this.vecTypeName = vecTypeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getObj_part() {
        return obj_part;
    }

    public void setObj_part(String obj_part) {
        this.obj_part = obj_part;
    }
}

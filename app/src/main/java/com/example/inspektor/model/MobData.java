package com.example.inspektor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MobData implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("no_inspec")
    @Expose
    private String no_inspec;

    @SerializedName("ba")
    @Expose
    private String ba;

    @SerializedName("running_account")
    @Expose
    private String runningAccount;

    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    @SerializedName("obj_part")
    @Expose
    private String objPart;

    @SerializedName("dam_date")
    @Expose
    private String damDate;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("loc")
    @Expose
    private String loc;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("note")
    @Expose
    private String note;

    @SerializedName("plan_date")
    @Expose
    private String planDate;

    @SerializedName("created_by")
    @Expose
    private String createdBy;

    @SerializedName("created_date")
    @Expose
    private String createdDate;

    @SerializedName("created_time")
    @Expose
    private String createdTime;

    @SerializedName("ztuagri_runacct_id")
    @Expose
    private int ztuagriRunacctId;

    @SerializedName("zinspec_vehicletype_id")
    @Expose
    private int zinspecVehicletypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_inspec() {
        return no_inspec;
    }

    public void setNo_inspec(String no_inspec) {
        this.no_inspec = no_inspec;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getRunningAccount() {
        return runningAccount;
    }

    public void setRunningAccount(String runningAccount) {
        this.runningAccount = runningAccount;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getObjPart() {
        return objPart;
    }

    public void setObjPart(String objPart) {
        this.objPart = objPart;
    }

    public String getDamDate() {
        return damDate;
    }

    public void setDamDate(String damDate) {
        this.damDate = damDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public int getZtuagriRunacctId() {
        return ztuagriRunacctId;
    }

    public void setZtuagriRunacctId(int ztuagriRunacctId) {
        this.ztuagriRunacctId = ztuagriRunacctId;
    }

    public int getZinspecVehicletypeId() {
        return zinspecVehicletypeId;
    }

    public void setZinspecVehicletypeId(int zinspecVehicletypeId) {
        this.zinspecVehicletypeId = zinspecVehicletypeId;
    }
}

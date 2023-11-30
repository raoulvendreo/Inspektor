package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "Inspec_Mob")
public class MobEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "COMPANY_CODE")
    private Integer companyCode;

    @ColumnInfo(name = "BA")
    private Integer BA;

    @ColumnInfo(name = "RUNNING_ACCOUNT")
    private String runningAccount;

    @ColumnInfo(name = "VEHICLE_TYPE")
    private String vehicleType;

    @ColumnInfo(name = "OBJ_PART")
    private String objPart;

    @ColumnInfo(name = "DAM_DATE")
    private String damDate;

    @ColumnInfo(name = "STATUS")
    private String status;

    @ColumnInfo(name = "LOC")
    private String loc;

    // INI MASIH BELUM FIX
    @ColumnInfo(name = "PHOTO")
    private String photo;
    // ------------------------

    @ColumnInfo(name = "NOTE")
    private String note;

    @ColumnInfo(name = "PLAN_DATE")
    private String planDate;

    @ColumnInfo(name = "CREATE_BY")
    private String createBy;

    @ColumnInfo(name = "CREATE_DATE")
    private String createDate;

    @ColumnInfo(name = "CREATE_TIME")
    private String createTime;

    public MobEntity(){

    }

    @Ignore
    public MobEntity(Integer id, Integer companyCode, Integer BA, String runningAccount, String vehicleType, String objPart, String damDate, String status, String loc, String photo, String note, String planDate, String createBy, String createDate, String createTime) {
        this.id = id;
        this.companyCode = companyCode;
        this.BA = BA;
        this.runningAccount = runningAccount;
        this.vehicleType = vehicleType;
        this.objPart = objPart;
        this.damDate = damDate;
        this.status = status;
        this.loc = loc;
        this.photo = photo;
        this.note = note;
        this.planDate = planDate;
        this.createBy = createBy;
        this.createDate = createDate;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getBA() {
        return BA;
    }

    public void setBA(Integer BA) {
        this.BA = BA;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

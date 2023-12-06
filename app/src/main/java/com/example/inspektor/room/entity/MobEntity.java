package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "MobTable")
public class MobEntity implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int mobId;

    @ColumnInfo(name = "no_inspec")
    private String mobNoInspec;

    @ColumnInfo(name = "ba")
    private String mobBa;

    @ColumnInfo(name = "running_account")
    private String mobRunningAccount;

    @ColumnInfo(name = "vehicle_type")
    private String mobVehicleType;

    @ColumnInfo(name = "obj_part")
    private String mobObjPart;

    @ColumnInfo(name = "dam_date")
    private String mobDamDate;

    @ColumnInfo(name = "status")
    private int mobStatus;

    @ColumnInfo(name = "loc")
    private String mobLoc;

    @ColumnInfo(name = "photo")
    private String mobPhoto;

    @ColumnInfo(name = "note")
    private String mobNote;

    @ColumnInfo(name = "plan_date")
    private String mobPlanDate;

    @ColumnInfo(name = "created_by")
    private String mobCreatedBy;

    @ColumnInfo(name = "created_date")
    private String mobCreatedDate;

    @ColumnInfo(name = "created_time")
    private String mobCreatedTime;

    @ColumnInfo(name = "ztuagri_runacct_id")
    private int mobZtuagriRunacctId;

    @ColumnInfo(name = "zinspec_vehicletype_id")
    private int mobZinspecVehicletypeId;

    public MobEntity(){

    }

    @Ignore
    public MobEntity(int mobId, String mobNoInspec, String mobBa, String mobRunningAccount, String mobVehicleType, String mobObjPart, String mobDamDate, int mobStatus, String mobLoc, String mobPhoto, String mobNote, String mobPlanDate, String mobCreatedBy, String mobCreatedDate, String mobCreatedTime, int mobZtuagriRunacctId, int mobZinspecVehicletypeId) {
        this.mobId = mobId;
        this.mobNoInspec = mobNoInspec;
        this.mobBa = mobBa;
        this.mobRunningAccount = mobRunningAccount;
        this.mobVehicleType = mobVehicleType;
        this.mobObjPart = mobObjPart;
        this.mobDamDate = mobDamDate;
        this.mobStatus = mobStatus;
        this.mobLoc = mobLoc;
        this.mobPhoto = mobPhoto;
        this.mobNote = mobNote;
        this.mobPlanDate = mobPlanDate;
        this.mobCreatedBy = mobCreatedBy;
        this.mobCreatedDate = mobCreatedDate;
        this.mobCreatedTime = mobCreatedTime;
        this.mobZtuagriRunacctId = mobZtuagriRunacctId;
        this.mobZinspecVehicletypeId = mobZinspecVehicletypeId;
    }

    public int getMobId() {
        return mobId;
    }

    public void setMobId(int mobId) {
        this.mobId = mobId;
    }

    public String getMobNoInspec() {
        return mobNoInspec;
    }

    public void setMobNoInspec(String mobNoInspec) {
        this.mobNoInspec = mobNoInspec;
    }

    public String getMobBa() {
        return mobBa;
    }

    public void setMobBa(String mobBa) {
        this.mobBa = mobBa;
    }

    public String getMobRunningAccount() {
        return mobRunningAccount;
    }

    public void setMobRunningAccount(String mobRunningAccount) {
        this.mobRunningAccount = mobRunningAccount;
    }

    public String getMobVehicleType() {
        return mobVehicleType;
    }

    public void setMobVehicleType(String mobVehicleType) {
        this.mobVehicleType = mobVehicleType;
    }

    public String getMobObjPart() {
        return mobObjPart;
    }

    public void setMobObjPart(String mobObjPart) {
        this.mobObjPart = mobObjPart;
    }

    public String getMobDamDate() {
        return mobDamDate;
    }

    public void setMobDamDate(String mobDamDate) {
        this.mobDamDate = mobDamDate;
    }

    public int getMobStatus() {
        return mobStatus;
    }

    public void setMobStatus(int mobStatus) {
        this.mobStatus = mobStatus;
    }

    public String getMobLoc() {
        return mobLoc;
    }

    public void setMobLoc(String mobLoc) {
        this.mobLoc = mobLoc;
    }

    public String getMobPhoto() {
        return mobPhoto;
    }

    public void setMobPhoto(String mobPhoto) {
        this.mobPhoto = mobPhoto;
    }

    public String getMobNote() {
        return mobNote;
    }

    public void setMobNote(String mobNote) {
        this.mobNote = mobNote;
    }

    public String getMobPlanDate() {
        return mobPlanDate;
    }

    public void setMobPlanDate(String mobPlanDate) {
        this.mobPlanDate = mobPlanDate;
    }

    public String getMobCreatedBy() {
        return mobCreatedBy;
    }

    public void setMobCreatedBy(String mobCreatedBy) {
        this.mobCreatedBy = mobCreatedBy;
    }

    public String getMobCreatedDate() {
        return mobCreatedDate;
    }

    public void setMobCreatedDate(String mobCreatedDate) {
        this.mobCreatedDate = mobCreatedDate;
    }

    public String getMobCreatedTime() {
        return mobCreatedTime;
    }

    public void setMobCreatedTime(String mobCreatedTime) {
        this.mobCreatedTime = mobCreatedTime;
    }

    public int getMobZtuagriRunacctId() {
        return mobZtuagriRunacctId;
    }

    public void setMobZtuagriRunacctId(int mobZtuagriRunacctId) {
        this.mobZtuagriRunacctId = mobZtuagriRunacctId;
    }

    public int getMobZinspecVehicletypeId() {
        return mobZinspecVehicletypeId;
    }

    public void setMobZinspecVehicletypeId(int mobZinspecVehicletypeId) {
        this.mobZinspecVehicletypeId = mobZinspecVehicletypeId;
    }
}

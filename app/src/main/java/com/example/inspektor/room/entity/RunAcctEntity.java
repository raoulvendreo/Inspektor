package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "RunningAccountTable")
public class RunAcctEntity implements Serializable {

    @PrimaryKey @NonNull
    @ColumnInfo(name = "id")
    private int runAcctId;

    @ColumnInfo(name = "running_account")
    private String runAcct;

    @ColumnInfo(name = "company_code")
    private String runAcctCompanyCode;

    @ColumnInfo(name = "estate")
    private String runAcctEstate;

    @ColumnInfo(name = "anln1")
    private int runAcctAnln1;

    @ColumnInfo(name = "class_ra")
    private String runAcctClassRA;

    @ColumnInfo(name = "status_flag")
    private String runAcctStatusFlag;

    @ColumnInfo(name = "kostl")
    private String runAcctKostl;

    @ColumnInfo(name = "class_group")
    private String runAcctClassGroup;

    @ColumnInfo(name = "license_plate")
    private String runAcctLicensePlate;

    @ColumnInfo(name = "running_text")
    private String runAcctRunningText;

    @ColumnInfo(name = "equnr")
    private String runAcctEqunr;

    public RunAcctEntity(){

    }

    @Ignore
    public RunAcctEntity(int runAcctId, String runAcct, String runAcctCompanyCode, String runAcctEstate, int runAcctAnln1, String runAcctClassRA, String runAcctStatusFlag, String runAcctKostl, String runAcctClassGroup, String runAcctLicensePlate, String runAcctRunningText, String runAcctEqunr) {
        this.runAcctId = runAcctId;
        this.runAcct = runAcct;
        this.runAcctCompanyCode = runAcctCompanyCode;
        this.runAcctEstate = runAcctEstate;
        this.runAcctAnln1 = runAcctAnln1;
        this.runAcctClassRA = runAcctClassRA;
        this.runAcctStatusFlag = runAcctStatusFlag;
        this.runAcctKostl = runAcctKostl;
        this.runAcctClassGroup = runAcctClassGroup;
        this.runAcctLicensePlate = runAcctLicensePlate;
        this.runAcctRunningText = runAcctRunningText;
        this.runAcctEqunr = runAcctEqunr;
    }

    public int getRunAcctId() {
        return runAcctId;
    }

    public void setRunAcctId(int runAcctId) {
        this.runAcctId = runAcctId;
    }

    public String getRunAcct() {
        return runAcct;
    }

    public void setRunAcct(String runAcct) {
        this.runAcct = runAcct;
    }

    public String getRunAcctCompanyCode() {
        return runAcctCompanyCode;
    }

    public void setRunAcctCompanyCode(String runAcctCompanyCode) {
        this.runAcctCompanyCode = runAcctCompanyCode;
    }

    public String getRunAcctEstate() {
        return runAcctEstate;
    }

    public void setRunAcctEstate(String runAcctEstate) {
        this.runAcctEstate = runAcctEstate;
    }

    public int getRunAcctAnln1() {
        return runAcctAnln1;
    }

    public void setRunAcctAnln1(int runAcctAnln1) {
        this.runAcctAnln1 = runAcctAnln1;
    }

    public String getRunAcctClassRA() {
        return runAcctClassRA;
    }

    public void setRunAcctClassRA(String runAcctClassRA) {
        this.runAcctClassRA = runAcctClassRA;
    }

    public String getRunAcctStatusFlag() {
        return runAcctStatusFlag;
    }

    public void setRunAcctStatusFlag(String runAcctStatusFlag) {
        this.runAcctStatusFlag = runAcctStatusFlag;
    }

    public String getRunAcctKostl() {
        return runAcctKostl;
    }

    public void setRunAcctKostl(String runAcctKostl) {
        this.runAcctKostl = runAcctKostl;
    }

    public String getRunAcctClassGroup() {
        return runAcctClassGroup;
    }

    public void setRunAcctClassGroup(String runAcctClassGroup) {
        this.runAcctClassGroup = runAcctClassGroup;
    }

    public String getRunAcctLicensePlate() {
        return runAcctLicensePlate;
    }

    public void setRunAcctLicensePlate(String runAcctLicensePlate) {
        this.runAcctLicensePlate = runAcctLicensePlate;
    }

    public String getRunAcctRunningText() {
        return runAcctRunningText;
    }

    public void setRunAcctRunningText(String runAcctRunningText) {
        this.runAcctRunningText = runAcctRunningText;
    }

    public String getRunAcctEqunr() {
        return runAcctEqunr;
    }

    public void setRunAcctEqunr(String runAcctEqunr) {
        this.runAcctEqunr = runAcctEqunr;
    }
}

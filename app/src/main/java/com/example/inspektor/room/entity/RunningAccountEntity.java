package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Inspec_RunningAccount")
public class RunningAccountEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "COMPANY_CODE")
    private Integer companyCode;

    @ColumnInfo(name = "ESTATE")
    private Integer estate;

    @ColumnInfo(name = "RUNNING_ACCOUNT")
    private String runningAccount;

    @ColumnInfo(name = "ANLN1")
    private Integer anln1;

    @ColumnInfo(name = "CLASS_RA")
    private Integer classRA;

    @ColumnInfo(name = "STATUS_FLAG")
    private String statusFlag;

    @ColumnInfo(name = "KOSTL")
    private String kostl;

    @ColumnInfo(name = "CLASS_GROUP")
    private Integer classGroup;

    @ColumnInfo(name = "LICENSE_PLATE")
    private String licensePlate;

    @ColumnInfo(name = "RUNNING_TEXT")
    private String runningText;

    @ColumnInfo(name = "EQUNR")
    private Integer equnr;

    public RunningAccountEntity(){

    }

    @Ignore
    public RunningAccountEntity(Integer id, Integer companyCode, Integer estate, String runningAccount, Integer anln1, Integer classRA, String statusFlag, String kostl, Integer classGroup, String licensePlate, String runningText, Integer equnr) {
        this.id = id;
        this.companyCode = companyCode;
        this.estate = estate;
        this.runningAccount = runningAccount;
        this.anln1 = anln1;
        this.classRA = classRA;
        this.statusFlag = statusFlag;
        this.kostl = kostl;
        this.classGroup = classGroup;
        this.licensePlate = licensePlate;
        this.runningText = runningText;
        this.equnr = equnr;
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

    public Integer getEstate() {
        return estate;
    }

    public void setEstate(Integer estate) {
        this.estate = estate;
    }

    public String getRunningAccount() {
        return runningAccount;
    }

    public void setRunningAccount(String runningAccount) {
        this.runningAccount = runningAccount;
    }

    public Integer getAnln1() {
        return anln1;
    }

    public void setAnln1(Integer anln1) {
        this.anln1 = anln1;
    }

    public Integer getClassRA() {
        return classRA;
    }

    public void setClassRA(Integer classRA) {
        this.classRA = classRA;
    }

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getKostl() {
        return kostl;
    }

    public void setKostl(String kostl) {
        this.kostl = kostl;
    }

    public Integer getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(Integer classGroup) {
        this.classGroup = classGroup;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getRunningText() {
        return runningText;
    }

    public void setRunningText(String runningText) {
        this.runningText = runningText;
    }

    public Integer getEqunr() {
        return equnr;
    }

    public void setEqunr(Integer equnr) {
        this.equnr = equnr;
    }
}

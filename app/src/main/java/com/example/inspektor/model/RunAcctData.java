package com.example.inspektor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RunAcctData implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("running_account")
    @Expose
    private String runningAccount;

    @SerializedName("company_code")
    @Expose
    private String companyCode;

    @SerializedName("estate")
    @Expose
    private String estate;

    @SerializedName("anln1")
    @Expose
    private int anln1 ;

    @SerializedName("class_ra")
    @Expose
    private String classRa;

    @SerializedName("status_flag")
    @Expose
    private String statusFlag;

    @SerializedName("kostl")
    @Expose
    private String kostl;

    @SerializedName("class_group")
    @Expose
    private String classGroup;

    @SerializedName("license_plate")
    @Expose
    private String licensePlate;

    @SerializedName("running_text")
    @Expose
    private String runningText;

    @SerializedName("equnr")
    @Expose
    private String equnr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRunningAccount() {
        return runningAccount;
    }

    public void setRunningAccount(String runningAccount) {
        this.runningAccount = runningAccount;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public int getAnln1() {
        return anln1;
    }

    public void setAnln1(int anln1) {
        this.anln1 = anln1;
    }

    public String getClassRa() {
        return classRa;
    }

    public void setClassRa(String classRa) {
        this.classRa = classRa;
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

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
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

    public String getEqunr() {
        return equnr;
    }

    public void setEqunr(String equnr) {
        this.equnr = equnr;
    }
}

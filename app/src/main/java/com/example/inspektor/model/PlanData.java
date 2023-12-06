package com.example.inspektor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlanData implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("company_code")
    @Expose
    private String companyCode;

    @SerializedName("ba")
    @Expose
    private String ba;

    @SerializedName("running_account")
    @Expose
    private String runningAccount;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("plan_date")
    @Expose
    private String planDate;

    @SerializedName("inspect_time")
    @Expose
    private String inspectTime;

    @SerializedName("inspect_date")
    @Expose
    private String inspectDate;

    @SerializedName("ztuagri_runacct_id")
    @Expose
    private int ztuagriRunacctId;

    @SerializedName("week")
    @Expose
    private int week;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(String inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }

    public int getZtuagriRunacctId() {
        return ztuagriRunacctId;
    }

    public void setZtuagriRunacctId(int ztuagriRunacctId) {
        this.ztuagriRunacctId = ztuagriRunacctId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}

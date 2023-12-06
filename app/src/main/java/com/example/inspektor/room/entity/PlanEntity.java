package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "PlanTable")
public class PlanEntity implements Serializable {

    @PrimaryKey @NonNull
    @ColumnInfo(name = "id")
    private int planId;

    @ColumnInfo(name = "company_code")
    private String planCompanyCode;

    @ColumnInfo(name = "ba")
    private String planBA;

    @ColumnInfo(name = "running_account")
    private String planRunningAccount;

    @ColumnInfo(name = "status")
    private String planStatus;

    @ColumnInfo(name = "plan_date")
    private String planDate;

    @ColumnInfo(name = "inspect_date")
    private String planInspectDate;

    @ColumnInfo(name = "inspect_time")
    private String planInspectTime;

    @ColumnInfo(name = "ztuagri_runacct_id")
    private int planZtuagriRunacctId;

    @ColumnInfo(name = "week")
    private int planWeek;

    public PlanEntity(){

    }

    @Ignore
    public PlanEntity(int planId, String planCompanyCode, String planBA, String planRunningAccount, String planStatus, String planDate, String planInspectDate, String planInspectTime, int planZtuagriRunacctId, int planWeek) {
        this.planId = planId;
        this.planCompanyCode = planCompanyCode;
        this.planBA = planBA;
        this.planRunningAccount = planRunningAccount;
        this.planStatus = planStatus;
        this.planDate = planDate;
        this.planInspectDate = planInspectDate;
        this.planInspectTime = planInspectTime;
        this.planZtuagriRunacctId = planZtuagriRunacctId;
        this.planWeek = planWeek;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanCompanyCode() {
        return planCompanyCode;
    }

    public void setPlanCompanyCode(String planCompanyCode) {
        this.planCompanyCode = planCompanyCode;
    }

    public String getPlanBA() {
        return planBA;
    }

    public void setPlanBA(String planBA) {
        this.planBA = planBA;
    }

    public String getPlanRunningAccount() {
        return planRunningAccount;
    }

    public void setPlanRunningAccount(String planRunningAccount) {
        this.planRunningAccount = planRunningAccount;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getPlanInspectDate() {
        return planInspectDate;
    }

    public void setPlanInspectDate(String planInspectDate) {
        this.planInspectDate = planInspectDate;
    }

    public String getPlanInspectTime() {
        return planInspectTime;
    }

    public void setPlanInspectTime(String planInspectTime) {
        this.planInspectTime = planInspectTime;
    }

    public int getPlanZtuagriRunacctId() {
        return planZtuagriRunacctId;
    }

    public void setPlanZtuagriRunacctId(int planZtuagriRunacctId) {
        this.planZtuagriRunacctId = planZtuagriRunacctId;
    }

    public int getPlanWeek() {
        return planWeek;
    }

    public void setPlanWeek(int planWeek) {
        this.planWeek = planWeek;
    }
}

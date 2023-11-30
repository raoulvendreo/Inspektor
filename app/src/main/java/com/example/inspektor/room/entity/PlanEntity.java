package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Inspec_Plan")
public class PlanEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "COMPANY_CODE")
    private Integer companyCode;

    @ColumnInfo(name = "BA")
    private Integer BA;

    @ColumnInfo(name = "RUNNING_ACCOUNT")
    private String runningAccount;

    @ColumnInfo(name = "STATUS")
    private String status;

    @ColumnInfo(name = "PLAN_DATE")
    private String planDate;

    @ColumnInfo(name = "INSPEC_DATE")
    private String inspecDate;

    public PlanEntity(){

    }

    @Ignore
    public PlanEntity(Integer id, Integer companyCode, Integer BA, String runningAccount, String status, String planDate, String inspecDate) {
        this.id = id;
        this.companyCode = companyCode;
        this.BA = BA;
        this.runningAccount = runningAccount;
        this.status = status;
        this.planDate = planDate;
        this.inspecDate = inspecDate;
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

    public String getInspecDate() {
        return inspecDate;
    }

    public void setInspecDate(String inspecDate) {
        this.inspecDate = inspecDate;
    }
}

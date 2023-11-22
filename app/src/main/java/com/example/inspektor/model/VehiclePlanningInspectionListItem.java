package com.example.inspektor.model;

import java.io.Serializable;

public class VehiclePlanningInspectionListItem implements Serializable {

    private String runningAccount;
    private String businessArea;
    private String status;
    private String planningDate;
    private String inspectDate;

    public VehiclePlanningInspectionListItem(String runningAccount, String businessArea, String status, String planningDate, String inspectDate) {
        this.runningAccount = runningAccount;
        this.businessArea = businessArea;
        this.status = status;
        this.planningDate = planningDate;
        this.inspectDate = inspectDate;
    }

    public String getRunningAccount() {
        return runningAccount;
    }

    public void setRunningAccount(String runningAccount) {
        this.runningAccount = runningAccount;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlanningDate() {
        return planningDate;
    }

    public void setPlanningDate(String planningDate) {
        this.planningDate = planningDate;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }
}

package com.example.inspektor.model;

import java.io.Serializable;
import java.util.Date;

public class VehicleDetailsListItem implements Serializable {

    private String runningAccount;
    private String businessArea;
    private String location;
    private String status;
    private String lastInspec;

    public VehicleDetailsListItem(String runningAccount, String businessArea, String location, String status, String lastInspec) {
        this.runningAccount = runningAccount;
        this.businessArea = businessArea;
        this.location = location;
        this.status = status;
        this.lastInspec = lastInspec;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastInspec() {
        return lastInspec;
    }

    public void setLastInspec(String lastInspec) {
        this.lastInspec = lastInspec;
    }
}

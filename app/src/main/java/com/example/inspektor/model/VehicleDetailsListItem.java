package com.example.inspektor.model;

import java.io.Serializable;
import java.util.Date;

public class VehicleDetailsListItem implements Serializable {

    private String runningAccount;
    private String businessArea;
    private String location;
    private int status;
    private Date lastInspec;

    public VehicleDetailsListItem(String runningAccount, String businessArea, String location, int status, Date lastInspec) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastInspec() {
        return lastInspec;
    }

    public void setLastInspec(Date lastInspec) {
        this.lastInspec = lastInspec;
    }
}

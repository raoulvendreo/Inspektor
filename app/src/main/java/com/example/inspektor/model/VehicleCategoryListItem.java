package com.example.inspektor.model;

public class VehicleCategoryListItem {

    private String vehicleCategory;
    private String conditionGood;
    private String conditionBad;
    private String notYetInspected;
    private String imgVehicle;

    public VehicleCategoryListItem(String vehicleCategory, String conditionGood, String conditionBad, String notYetInspected, String imgVehicle) {
        this.vehicleCategory = vehicleCategory;
        this.conditionGood = conditionGood;
        this.conditionBad = conditionBad;
        this.notYetInspected = notYetInspected;
        this.imgVehicle = imgVehicle;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getConditionGood() {
        return conditionGood;
    }

    public void setConditionGood(String conditionGood) {
        this.conditionGood = conditionGood;
    }

    public String getConditionBad() {
        return conditionBad;
    }

    public void setConditionBad(String conditionBad) {
        this.conditionBad = conditionBad;
    }

    public String getNotYetInspected() {
        return notYetInspected;
    }

    public void setNotYetInspected(String notYetInspected) {
        this.notYetInspected = notYetInspected;
    }

    public String getImgVehicle() {
        return imgVehicle;
    }

    public void setImgVehicle(String imgVehicle) {
        this.imgVehicle = imgVehicle;
    }
}

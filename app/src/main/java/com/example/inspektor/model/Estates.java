package com.example.inspektor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Estates implements Serializable {

    @SerializedName("id")
    @Expose
    private String estateId;

    @SerializedName("code")
    @Expose
    private String estateCode;

    @SerializedName("name")
    @Expose
    private String estateName;

    @SerializedName("description")
    @Expose
    private String estateDescription;

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getEstateCode() {
        return estateCode;
    }

    public void setEstateCode(String estateCode) {
        this.estateCode = estateCode;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getEstateDescription() {
        return estateDescription;
    }

    public void setEstateDescription(String estateDescription) {
        this.estateDescription = estateDescription;
    }
}

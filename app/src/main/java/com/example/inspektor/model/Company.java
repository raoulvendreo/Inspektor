package com.example.inspektor.model;

import androidx.room.TypeConverters;

import com.example.inspektor.typeconverters.EstatesTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

    // terakhir di 1-12-23
    @SerializedName("id")
    @Expose
    private String companyId;

    @SerializedName("code")
    @Expose
    private String companyCode;

    @SerializedName("name")
    @Expose
    private String companyName;

    @SerializedName("description")
    @Expose
    private String companyDescription;

    @SerializedName("estates")
    @Expose
    @TypeConverters(EstatesTypeConverter.class)
    private List<Estates> companyEstates = null;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public List<Estates> getCompanyEstates() {
        return companyEstates;
    }

    public void setCompanyEstates(List<Estates> companyEstates) {
        this.companyEstates = companyEstates;
    }
}

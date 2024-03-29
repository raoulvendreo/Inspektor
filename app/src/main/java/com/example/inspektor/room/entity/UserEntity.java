package com.example.inspektor.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.inspektor.model.Company;
import com.example.inspektor.typeconverters.CompanyTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "UserTable", indices = @Index(value = {"id"}, unique = true))
public class UserEntity implements Serializable {

    @PrimaryKey @NonNull
    @ColumnInfo(name = "id")
    private String userId;

    @ColumnInfo(name = "code")
    private String userCode;

    @ColumnInfo(name = "username")
    private String userUsername;

    @ColumnInfo(name = "email")
    private String userEmail;

    @ColumnInfo(name = "fullname")
    private String userFullname;

//    @SerializedName("company")
//    @Expose
    @ColumnInfo(name = "company")
    @TypeConverters(CompanyTypeConverter.class)
    private List<Company> userCompany = null;

    public UserEntity(){

    }

    @Ignore
    public UserEntity(@NonNull String userId, String userCode, String userUsername, String userEmail, String userFullname, List<Company> userCompany) {
        this.userId = userId;
        this.userCode = userCode;
        this.userUsername = userUsername;
        this.userEmail = userEmail;
        this.userFullname = userFullname;
        this.userCompany = userCompany;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public List<Company> getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(List<Company> userCompany) {
        this.userCompany = userCompany;
    }
}

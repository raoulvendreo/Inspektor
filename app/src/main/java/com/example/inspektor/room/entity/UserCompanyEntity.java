//package com.example.inspektor.room.entity;
//
//import androidx.annotation.NonNull;
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.Ignore;
//import androidx.room.PrimaryKey;
//
//import java.io.Serializable;
//
//@Entity(tableName = "UserCompanyTable")
//public class UserCompanyEntity implements Serializable {
//
//    @PrimaryKey @NonNull
//    @ColumnInfo(name = "id")
//    private String userCompanyId;
//
//    @ColumnInfo(name = "code")
//    private String userCompanyCode;
//
//    @ColumnInfo(name = "name")
//    private String userCompanyName;
//
//    @ColumnInfo(name = "description")
//    private String userCompanyDescription;
//
//    public UserCompanyEntity(){
//
//    }
//
//    @Ignore
//    public UserCompanyEntity(@NonNull String userCompanyId, String userCompanyCode, String userCompanyName, String userCompanyDescription) {
//        this.userCompanyId = userCompanyId;
//        this.userCompanyCode = userCompanyCode;
//        this.userCompanyName = userCompanyName;
//        this.userCompanyDescription = userCompanyDescription;
//    }
//
//    @NonNull
//    public String getUserCompanyId() {
//        return userCompanyId;
//    }
//
//    public void setUserCompanyId(@NonNull String userCompanyId) {
//        this.userCompanyId = userCompanyId;
//    }
//
//    public String getUserCompanyCode() {
//        return userCompanyCode;
//    }
//
//    public void setUserCompanyCode(String userCompanyCode) {
//        this.userCompanyCode = userCompanyCode;
//    }
//
//    public String getUserCompanyName() {
//        return userCompanyName;
//    }
//
//    public void setUserCompanyName(String userCompanyName) {
//        this.userCompanyName = userCompanyName;
//    }
//
//    public String getUserCompanyDescription() {
//        return userCompanyDescription;
//    }
//
//    public void setUserCompanyDescription(String userCompanyDescription) {
//        this.userCompanyDescription = userCompanyDescription;
//    }
//}
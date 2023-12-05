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
//@Entity(tableName = "UserCompanyEstatesTable")
//public class UserCompanyEstatesEntity implements Serializable {
//
//    @PrimaryKey
//    @NonNull
//    @ColumnInfo(name = "id")
//    private String userCompanyEstateId;
//
//    @ColumnInfo(name = "code")
//    private String userCompanyEstateCode;
//
//    @ColumnInfo(name = "name")
//    private String userCompanyEstateName;
//
//    @ColumnInfo(name = "description")
//    private String userCompanyEstateDescription;
//
//    public UserCompanyEstatesEntity(){
//
//    }
//
//    @Ignore
//    public UserCompanyEstatesEntity(@NonNull String userCompanyEstateId, String userCompanyEstateCode, String userCompanyEstateName, String userCompanyEstateDescription) {
//        this.userCompanyEstateId = userCompanyEstateId;
//        this.userCompanyEstateCode = userCompanyEstateCode;
//        this.userCompanyEstateName = userCompanyEstateName;
//        this.userCompanyEstateDescription = userCompanyEstateDescription;
//    }
//
//    @NonNull
//    public String getUserCompanyEstateId() {
//        return userCompanyEstateId;
//    }
//
//    public void setUserCompanyEstateId(@NonNull String userCompanyEstateId) {
//        this.userCompanyEstateId = userCompanyEstateId;
//    }
//
//    public String getUserCompanyEstateCode() {
//        return userCompanyEstateCode;
//    }
//
//    public void setUserCompanyEstateCode(String userCompanyEstateCode) {
//        this.userCompanyEstateCode = userCompanyEstateCode;
//    }
//
//    public String getUserCompanyEstateName() {
//        return userCompanyEstateName;
//    }
//
//    public void setUserCompanyEstateName(String userCompanyEstateName) {
//        this.userCompanyEstateName = userCompanyEstateName;
//    }
//
//    public String getUserCompanyEstateDescription() {
//        return userCompanyEstateDescription;
//    }
//
//    public void setUserCompanyEstateDescription(String userCompanyEstateDescription) {
//        this.userCompanyEstateDescription = userCompanyEstateDescription;
//    }
//}

package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Logged_User_Data")
public class LoggedUserEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "USER_AD")
    private String userAD;

    @ColumnInfo(name = "NIK")
    private Integer nik;

    @ColumnInfo(name = "AMA")
    private String ama;

    public LoggedUserEntity(){

    }

    @Ignore
    public LoggedUserEntity(Integer id, String userAD, Integer nik, String ama) {
        this.id = id;
        this.userAD = userAD;
        this.nik = nik;
        this.ama = ama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAD() {
        return userAD;
    }

    public void setUserAD(String userAD) {
        this.userAD = userAD;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getAma() {
        return ama;
    }

    public void setAma(String ama) {
        this.ama = ama;
    }
}

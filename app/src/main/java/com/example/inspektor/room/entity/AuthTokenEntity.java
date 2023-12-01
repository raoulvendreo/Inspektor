package com.example.inspektor.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity
public class AuthTokenEntity {

    @ColumnInfo (name = "token")
    private String token;

    public AuthTokenEntity(){

    }

    @Ignore
    public AuthTokenEntity(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

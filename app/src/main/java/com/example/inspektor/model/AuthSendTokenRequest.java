package com.example.inspektor.model;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

public class AuthSendTokenRequest {

    @SerializedName("token")
    private String token = "";

    public AuthSendTokenRequest(){

    }

    @Ignore
    public AuthSendTokenRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.example.inspektor.model;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

public class GLOBALSendTokenRequest {

    @SerializedName("token")
    private String token = "";

    public GLOBALSendTokenRequest(){

    }

    @Ignore
    public GLOBALSendTokenRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

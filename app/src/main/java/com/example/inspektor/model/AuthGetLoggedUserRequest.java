package com.example.inspektor.model;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

public class AuthGetLoggedUserRequest {

    @SerializedName("token")
    private String token = "";

    public AuthGetLoggedUserRequest(){

    }

    @Ignore
    public AuthGetLoggedUserRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

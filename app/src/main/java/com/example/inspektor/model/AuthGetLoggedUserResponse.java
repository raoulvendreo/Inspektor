package com.example.inspektor.model;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthGetLoggedUserResponse implements Serializable {

    @SerializedName("data")
    private UserData data;

    @SerializedName("elapsed_time")
    private String elapsed_time;

    @SerializedName("message")
    private String message;

    public AuthGetLoggedUserResponse(){

    }

    @Ignore
    public AuthGetLoggedUserResponse(UserData data, String elapsed_time, String message) {
        this.data = data;
        this.elapsed_time = elapsed_time;
        this.message = message;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public String getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(String elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

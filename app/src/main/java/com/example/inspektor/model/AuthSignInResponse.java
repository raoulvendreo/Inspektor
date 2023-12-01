package com.example.inspektor.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthSignInResponse implements Serializable {

    @SerializedName("data")
    private AuthToken data;

    @SerializedName("elapsed_time")
    private String elapsed_time;

    @SerializedName("message")
    private String message;

    public AuthToken getData() {
        return data;
    }

    public void setData(AuthToken data) {
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

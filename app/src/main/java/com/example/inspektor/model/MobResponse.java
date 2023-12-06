package com.example.inspektor.model;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MobResponse implements Serializable {

    @SerializedName("data")
    private List<MobData> data;

    @SerializedName("elapsed_time")
    private String elapsed_time;

    @SerializedName("message")
    private String message;

    public MobResponse(){

    }
    @Ignore
    public MobResponse(List<MobData> data, String elapsed_time, String message) {
        this.data = data;
        this.elapsed_time = elapsed_time;
        this.message = message;
    }

    public List<MobData> getData() {
        return data;
    }

    public void setData(List<MobData> data) {
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

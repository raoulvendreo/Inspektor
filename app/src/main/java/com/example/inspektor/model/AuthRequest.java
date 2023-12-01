package com.example.inspektor.model;

import com.google.gson.annotations.SerializedName;

public class AuthRequest {


    /*@SerializedName("ldap")
    boolean ldap;*/
    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    @SerializedName("domain")
    String domain;

    public AuthRequest(String username, String password, String domain) {
//        this.ldap = ldap;
        this.username = username;
        this.password = password;
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    /*public boolean isLdap() {
        return ldap;
    }

    public void setLdap(boolean ldap) {
        this.ldap = ldap;
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

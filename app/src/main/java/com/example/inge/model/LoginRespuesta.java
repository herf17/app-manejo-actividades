package com.example.inge.model;

import com.google.gson.annotations.SerializedName;

public class LoginRespuesta {
    @SerializedName("token")
    private String token;

    @Override
    public String toString() {
        return "LoginRespuesta{" +
                "token='" + token + '\'' +
                '}';
    }

    public LoginRespuesta(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.assignment.callsign.models;


public class AuthRequest {
    private String username;
    private String password;

    public AuthRequest(){}

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

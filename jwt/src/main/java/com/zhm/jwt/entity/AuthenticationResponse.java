package com.zhm.jwt.entity;

public class AuthenticationResponse {

    // fields
    private String jwtToken;

    // constructors
    public AuthenticationResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // getters and setters
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}

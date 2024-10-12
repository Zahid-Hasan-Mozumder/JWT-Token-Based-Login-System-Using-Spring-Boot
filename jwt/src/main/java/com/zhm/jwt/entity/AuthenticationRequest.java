package com.zhm.jwt.entity;

public class AuthenticationRequest {

    // fields
    private String email;
    private String password;

    // constructors
    public AuthenticationRequest() {}

    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // getters and setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

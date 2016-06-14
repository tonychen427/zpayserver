package com.clientsbox.core.model;

public class User {

    public String id;
    public String username;
    public String password;
    public String email;
    public String mobile;
    public String fcm_deviceRegId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFcm_deviceRegId() {
        return fcm_deviceRegId;
    }

    public void setFcm_deviceRegId(String fcm_deviceRegId) {
        this.fcm_deviceRegId = fcm_deviceRegId;
    }
    
}

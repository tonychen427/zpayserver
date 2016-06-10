package com.clientsbox.core.model;

public class User {
    public String id;
    public String username;
    public String password;
    public String email;
    public String gcm_registeration_id;

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

    public String getGcm_registeration_id() {
        return gcm_registeration_id;
    }

    public void setGcm_registeration_id(String gcm_registeration_id) {
        this.gcm_registeration_id = gcm_registeration_id;
    }
    
    
    
}

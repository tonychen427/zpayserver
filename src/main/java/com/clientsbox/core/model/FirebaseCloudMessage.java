package com.clientsbox.core.model;

import java.util.List;

public class FirebaseCloudMessage {
    
    public String data;
    public List<String> deviceRegistrationTokens;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getDeviceRegistrationTokens() {
        return deviceRegistrationTokens;
    }

    public void setDeviceRegistrationTokens(List<String> deviceRegistrationTokens) {
        this.deviceRegistrationTokens = deviceRegistrationTokens;
    }
    
}

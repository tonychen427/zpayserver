package com.clientsbox.core.model;

import java.util.List;

public class FirebaseCloudMessage {
    
    public String data;
    public List<String> fcm_deviceRegIds;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getFcm_deviceRegIds() {
        return fcm_deviceRegIds;
    }

    public void setFcm_deviceRegIds(List<String> fcm_deviceRegIds) {
        this.fcm_deviceRegIds = fcm_deviceRegIds;
    }
 
}

package com.clientsbox.core.model;

public class UserAccessToken {
    public String id;
    
    public String apiKey;
    public String deviceId;
    public String accessToken;
    public String fcm_deviceRegId;
    
    public String userId;
    public String deviceUniqueId;
    public String fcmPushToken;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

      public String getFcm_deviceRegId() {
        return fcm_deviceRegId;
    }

    public void setFcm_deviceRegId(String fcm_deviceRegId) {
        this.fcm_deviceRegId = fcm_deviceRegId;
    }

    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public void setDeviceUniqueId(String deviceUniqueId) {
        this.deviceUniqueId = deviceUniqueId;
    }

    public String getFcmPushToken() {
        return fcmPushToken;
    }

    public void setFcmPushToken(String fcmPushToken) {
        this.fcmPushToken = fcmPushToken;
    }
    
}

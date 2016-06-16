package com.clientsbox.core.model;

public class FirebaseCloudMessage {
    
    public String data;
    public String notificationUserId;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNotificationUserId() {
        return notificationUserId;
    }

    public void setNotificationUserId(String notificationUserId) {
        this.notificationUserId = notificationUserId;
    }

}

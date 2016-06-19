package com.clientsbox.core.model;

public class FirebaseCloudMessage {

    public static class data {

        public String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
    public String to;
    public data data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public data getData() {
        return data;
    }

    public void setData(data data) {
        this.data = data;
    }

}

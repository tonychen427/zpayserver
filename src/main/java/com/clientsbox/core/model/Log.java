package com.clientsbox.core.model;

public class Log {
    public String id;
    public String errorLevel;
    public String errorMSg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getErrorMSg() {
        return errorMSg;
    }

    public void setErrorMSg(String errorMSg) {
        this.errorMSg = errorMSg;
    }    
}

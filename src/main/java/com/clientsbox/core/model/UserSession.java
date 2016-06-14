package com.clientsbox.core.model;

public class UserSession {
   
    public String userId;
    public String targetURL;
    public String accessToken;
    public String mAuthorizationKey;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTargetURL() {
        return targetURL;
    }

    public void setTargetURL(String targetURL) {
        this.targetURL = targetURL;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getmAuthorizationKey() {
        return mAuthorizationKey;
    }

    public void setmAuthorizationKey(String mAuthorizationKey) {
        this.mAuthorizationKey = mAuthorizationKey;
    }

  
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserAccessToken;
import java.util.List;

/**
 *
 * @author Insprion
 */
public interface IUserAccessTokenService {

    /* Basic CRUD */
    public List<UserAccessToken> getUserAccessTokenList();

    public UserAccessToken getUserAccessTokenById(String id);

    public String insertUserAccessToken(UserAccessToken mUserAccessToken);

    public UserAccessToken updateUserAccessToken(String id, UserAccessToken mUserAccessToken);

    public boolean deleteUserAccessToken(String id);
    
    
    public UserAccessToken getUserAccessTokenbyUserIdDeviceId (String mAPIKey, String mUserId, String mDeviceId, String mFCMPushToken);
    
    public List<UserAccessToken> getAccessToken(final String mAccessTokenValid) ;
    
    
}

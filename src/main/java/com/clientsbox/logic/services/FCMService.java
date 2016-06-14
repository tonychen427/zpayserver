/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IFCMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FCMService implements IFCMService {

    @Autowired
    IFCMRepository _fcmRepository;
    
    @Override
    public boolean SendDownstreamMessage(FirebaseCloudMessage mFirebaseCloudMessage, String mAuthorizationKey) {
        
        UserSession mUserSession = new UserSession();
        
        
        
        boolean successful = _fcmRepository.SendDownstreamMessage(mFirebaseCloudMessage, mUserSession);
        return true;
    }

}

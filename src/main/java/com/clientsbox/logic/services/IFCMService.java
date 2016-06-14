package com.clientsbox.logic.services;

import com.clientsbox.core.model.FirebaseCloudMessage;

public interface IFCMService {

    public boolean SendDownstreamMessage (FirebaseCloudMessage mFirebaseCloudMessage, String mAuthorizationKey);
    
}

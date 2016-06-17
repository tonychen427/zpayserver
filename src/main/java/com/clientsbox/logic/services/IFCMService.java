package com.clientsbox.logic.services;

import com.clientsbox.core.model.CloudMessage;

public interface IFCMService {

    public boolean SendDownstreamMessage (CloudMessage mCloudMessage);
    
}

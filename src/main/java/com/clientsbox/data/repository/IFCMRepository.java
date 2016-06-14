/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.core.model.UserSession;

/**
 *
 * @author Insprion
 */
public interface IFCMRepository {
    public boolean SendDownstreamMessage (FirebaseCloudMessage mFirebaseCloudMessage, UserSession mUserSession);
}

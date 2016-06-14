/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.HttpConnectionHelper;
import org.springframework.stereotype.Repository;

@Repository
public class FCMRepository extends HttpConnectionHelper implements IFCMRepository{

    @Override
    public boolean SendDownstreamMessage(FirebaseCloudMessage mFirebaseCloudMessage, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package com.clientsbox.logic.services;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Override
    public UserSession getUserSessionByUsernamePassword(User mUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserSession registerUser(User mUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateGCMRegistrationIdByUserId(String mUserId, String GCMRegistrationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}

package com.clientsbox.logic.services;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository _userRepository;
    
    @Override
    public UserSession getUserSessionByUsernamePassword(User mUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserSession registerUser(User mUser) {
        UserSession mUserSession = new UserSession();
        _userRepository.updateUser(mUser, mUserSession);
        return mUserSession;
    }

    @Override
    public void updateGCMRegistrationIdByUserId(String mUserId, String GCMRegistrationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}

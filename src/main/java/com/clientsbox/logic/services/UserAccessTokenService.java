package com.clientsbox.logic.services;

import com.clientsbox.core.model.UserAccessToken;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IUserAccessTokenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccessTokenService implements IUserAccessTokenService{

    @Autowired
    IAPIProvisioningService _APIProvisioningService;
    
    @Autowired
    IUserAccessTokenRepository _IUserAccessTokenRepository;
    
    @Override
    public List<UserAccessToken> getUserAccessTokenList() {
        UserSession mUserSession = new UserSession();
        return _IUserAccessTokenRepository.getAllUserAccessTokens(mUserSession);
    }

    @Override
    public UserAccessToken getUserAccessTokenById(String id) {
        UserSession mUserSession = new UserSession();
        return _IUserAccessTokenRepository.getUserAccessTokenById(id, mUserSession);
    }

    @Override
    public String insertUserAccessToken(UserAccessToken mUserAccessToken) {
       UserSession mUserSession = new UserSession();
       return _IUserAccessTokenRepository.insertUserAccessToken(mUserAccessToken, mUserSession);
    }

    @Override
    public UserAccessToken updateUserAccessToken(String id, UserAccessToken mUserAccessToken) {
        UserSession mUserSession = new UserSession();
        return _IUserAccessTokenRepository.updateUserAccessToken(id, mUserAccessToken, mUserSession);
    }

    @Override
    public boolean deleteUserAccessToken(String id) {
         UserSession mUserSession = new UserSession();
         return _IUserAccessTokenRepository.deleteUserAccessToken(id, mUserSession);
    }

}

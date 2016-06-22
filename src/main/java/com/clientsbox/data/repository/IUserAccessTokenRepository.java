package com.clientsbox.data.repository;

import com.clientsbox.core.model.UserAccessToken;
import com.clientsbox.core.model.UserSession;
import java.util.List;

public interface IUserAccessTokenRepository {

    public List<UserAccessToken> getAllUserAccessTokens(UserSession mUserSession);

    public UserAccessToken getUserAccessTokenById(String id, UserSession mUserSession);

    public String insertUserAccessToken(UserAccessToken mUserAccessToken, UserSession mUserSession);

    public UserAccessToken updateUserAccessToken(String id, UserAccessToken mUserAccessToken, UserSession mUserSession);

    public boolean deleteUserAccessToken(String id, UserSession mUserSession);
}

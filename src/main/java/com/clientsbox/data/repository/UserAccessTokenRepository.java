package com.clientsbox.data.repository;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.UserAccessToken;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.RepositoryBase;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccessTokenRepository extends RepositoryBase implements IUserAccessTokenRepository {

    @Override
    public List<UserAccessToken> getAllUserAccessTokens(UserSession mUserSession) {
        return this.getAllRepository(mUserSession, SystemInfo.DbNameUserAccessToken, UserAccessToken.class );
    }

    @Override
    public UserAccessToken getUserAccessTokenById(String id, UserSession mUserSession) {
        return this.getRepositoryById(id, mUserSession, SystemInfo.DbNameUserAccessToken, UserAccessToken.class);
    }

    @Override
    public String insertUserAccessToken(UserAccessToken mUserAccessToken, UserSession mUserSession) {
        return this.insertRepository(mUserAccessToken, mUserSession, SystemInfo.DbNameUserAccessToken);
    }

    @Override
    public UserAccessToken updateUserAccessToken(String id, UserAccessToken mUserAccessToken, UserSession mUserSession) {
        return this.updateRepository(id, mUserAccessToken, mUserSession, SystemInfo.DbNameUserAccessToken);
    }

    @Override
    public boolean deleteUserAccessToken(String id, UserSession mUserSession) {    
        return this.deleteRepository(id, mUserSession, SystemInfo.DbNameUserAccessToken);
    }

    @Override
    protected <T> T mapListRepository(String id, String mValue) {
        Gson gson = new Gson();
        UserAccessToken mUserAccessToken = gson.fromJson(mValue, UserAccessToken.class);
        mUserAccessToken.setId(id);
        return (T) mUserAccessToken;
    }
}

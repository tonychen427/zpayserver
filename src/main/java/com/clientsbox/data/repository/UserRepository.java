package com.clientsbox.data.repository;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.RepositoryBase;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends RepositoryBase implements IUserRepository {

    @Override
    public List<User> getAllUsers(UserSession mUserSession) {
        return this.getAllRepository(mUserSession, SystemInfo.DbNameUsers, User.class);
    }

    @Override
    public User getUserById(String id, UserSession mUserSession) {
        return this.getRepositoryById(id, mUserSession, SystemInfo.DbNameUsers, User.class);
    }

    @Override
    public String insertUser(User mUser, UserSession mUserSession) {
        return this.insertRepository(mUser, mUserSession, SystemInfo.DbNameUsers);
    }

    @Override
    public User updateUser(String id, User mUser, UserSession mUserSession) {
        return this.updateRepository(id, mUser, mUserSession, SystemInfo.DbNameUsers);
    }

    @Override
    public boolean deleteUser(String id, UserSession mUserSession) {
        return this.deleteRepository(id, mUserSession, SystemInfo.DbNameUsers);
    }

    @Override
    protected <T> T mapListRepository(String id, String mValue) {
        Gson gson = new Gson();
        User mUser = gson.fromJson(mValue, User.class);
        mUser.setId(id);
        return (T) mUser;
    }

}

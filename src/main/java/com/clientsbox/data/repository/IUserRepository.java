package com.clientsbox.data.repository;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import java.util.List;

public interface IUserRepository {
     public List<User> getAllUsers(UserSession mUserSession);
    public User getUserById(String id, UserSession mUserSession);
    public void createUser(User mUser, UserSession mUserSession);
    public void updateUser(User mUser, UserSession mUserSession);
    public void deleteUser(User mUser, UserSession mUserSession);
}

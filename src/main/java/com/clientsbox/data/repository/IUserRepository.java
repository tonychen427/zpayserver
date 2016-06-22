package com.clientsbox.data.repository;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import java.util.List;

public interface IUserRepository {
    public List<User> getAllUsers(UserSession mUserSession);
    public User getUserById(String id, UserSession mUserSession);
    public String insertUser(User mUser, UserSession mUserSession);
    public User updateUser(String id, User mUser, UserSession mUserSession);
    public boolean deleteUser(String id, UserSession mUserSession);
}

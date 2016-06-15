package com.clientsbox.data.repository;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import java.util.List;

public interface IUserRepository {
    public List<User> getAllUsers(UserSession mUserSession);
    public User getUserById(String id, UserSession mUserSession);
    public String insertUser(User mUser, UserSession mUserSession);
    public void updateUser(User mUser, UserSession mUserSession);
    public void deleteUser(String id, UserSession mUserSession);
    
    public User getUserInfoByUsernamePassword(String mUsername, String Password);
}

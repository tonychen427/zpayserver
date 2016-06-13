/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import java.util.List;

public interface IUserService {

    public List<User> getUsers();
    
    public UserSession getUserSessionByUsernamePassword(User mUser);
    public UserSession registerUser(User mUser);
    
    public void updateGCMRegistrationIdByUserId(String  mUserId, String GCMRegistrationId);
}

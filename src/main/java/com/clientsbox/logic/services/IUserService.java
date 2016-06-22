/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.clientsbox.core.model.User;
import java.util.List;

public interface IUserService {

    public List<User> getUsers();
    public User getUserById(String id);
    public String insertUser(User mUser);
    public User updateUser(String id, User mUser);
    public boolean deleteUser(String id);
    
}

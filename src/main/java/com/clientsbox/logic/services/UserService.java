package com.clientsbox.logic.services;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IAPIProvisioningRepository;
import com.clientsbox.data.repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository _userRepository;
    
    @Autowired
    IAPIProvisioningRepository _IAPIProvisioningRepository;

    @Override
    public List<User> getUsers() {
        UserSession mUserSession = new UserSession();
        return _userRepository.getAllUsers(mUserSession);
    }

    @Override
    public User getUserById(String id) {
        UserSession mUserSession = new UserSession();
        return _userRepository.getUserById(id, mUserSession);
    }

    @Override
    public String insertUser(User mUser) {
        UserSession mUserSession = new UserSession();
        return _userRepository.insertUser(mUser, mUserSession);
    }

    @Override
    public User updateUser(String id, User mUser) {
        UserSession mUserSession = new UserSession();
        return _userRepository.updateUser(id, mUser, mUserSession);        
    }

    @Override
    public boolean deleteUser(String Id) {
        UserSession mUserSession = new UserSession();
        return _userRepository.deleteUser(Id, mUserSession);
    }

}

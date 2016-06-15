package com.clientsbox.logic.services;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IAPIProvisioningRepository;
import com.clientsbox.data.repository.IUserRepository;
import java.util.List;
import java.util.UUID;
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
    public void insertUser(User mUser) {
        UserSession mUserSession = new UserSession();
        String insertId = _userRepository.insertUser(mUser, mUserSession);
        APIProvisioning mAPIProvisioning = new APIProvisioning();
        mAPIProvisioning.setUserId(insertId);
        mAPIProvisioning.setAuthorizationKey(UUID.randomUUID().toString());
        _IAPIProvisioningRepository.insertAPIProvisioning(null);
    }

    @Override
    public void updateUser(User mUser) {
        UserSession mUserSession = new UserSession();
        _userRepository.updateUser(mUser, mUserSession);
    }

    @Override
    public void deleteUser(String Id) {
        UserSession mUserSession = new UserSession();
        _userRepository.deleteUser(null, mUserSession);
    }

}

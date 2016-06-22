package com.clientsbox.logic.services;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IAPIProvisioningRepository;
import com.clientsbox.data.repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APIProvisioningService implements IAPIProvisioningService {

    @Autowired
    IUserRepository _userRepository;

    @Autowired
    IAPIProvisioningRepository _apiProvisioningRepository;

    @Override
    public List<APIProvisioning> getAllAPIProvisioning() {
        UserSession mUserSession = new UserSession();
        return _apiProvisioningRepository.getAllAPIProvisioning(mUserSession);
    }

    @Override
    public APIProvisioning getAPIProvisioningById(String id) {
        UserSession mUserSession = new UserSession();
        return _apiProvisioningRepository.getAPIProvisioningById(id, mUserSession);
    }

    @Override
    public String insertAPIProvisioning(APIProvisioning mAPIProvisioning) {
        UserSession mUserSession = new UserSession();
        return _apiProvisioningRepository.insertAPIProvisioning(mAPIProvisioning, mUserSession);
    }

    @Override
    public APIProvisioning updateAPIProvisioning(String id, APIProvisioning mAPIProvisioning) {
        UserSession mUserSession = new UserSession();
        return _apiProvisioningRepository.updateAPIProvisioning(id, mAPIProvisioning, mUserSession);
    }

    @Override
    public boolean deleteAPIProvisioning(String Id) {
        UserSession mUserSession = new UserSession();
        return _apiProvisioningRepository.deleteAPIProvisioning(Id, mUserSession);
    }

}

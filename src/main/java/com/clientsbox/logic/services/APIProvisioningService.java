package com.clientsbox.logic.services;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.User;
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
        return _apiProvisioningRepository.getAllAPIProvisioning();
    }

    @Override
    public APIProvisioning getAPIProvisioningById(String id) {
        return _apiProvisioningRepository.getAPIProvisioningById(id);
    }

    @Override
    public void insertAPIProvisioning(APIProvisioning mAPIProvisioning) {
        _apiProvisioningRepository.insertAPIProvisioning(mAPIProvisioning);
    }

    @Override
    public void updateAPIProvisioning(APIProvisioning mAPIProvisioning) {
        _apiProvisioningRepository.updateAPIProvisioning(mAPIProvisioning);
    }

    @Override
    public void deleteAPIProvisioning(String Id) {
        _apiProvisioningRepository.deleteAPIProvisioning(Id);
    }

    @Override
    public APIProvisioning getAPIProvisioningInfoByUsernamePassword(String mUsername, String Password) {
        User mUser = _userRepository.getUserInfoByUsernamePassword(mUsername, Password);
        APIProvisioning mAPIProvisioning = this.getAPIProvisioningById(mUser.getId());
        return mAPIProvisioning;
    }
}

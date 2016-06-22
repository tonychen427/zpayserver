package com.clientsbox.data.repository;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.UserSession;
import java.util.List;

public interface IAPIProvisioningRepository {

    public List<APIProvisioning> getAllAPIProvisioning(UserSession mUserSession);

    public APIProvisioning getAPIProvisioningById(String id, UserSession mUserSession);

    public String insertAPIProvisioning(APIProvisioning mAPIProvisioning, UserSession mUserSession);

    public APIProvisioning updateAPIProvisioning(String id, APIProvisioning mAPIProvisioning, UserSession mUserSession);

    public boolean deleteAPIProvisioning(String Id, UserSession mUserSession);
}


package com.clientsbox.logic.services;

import com.clientsbox.core.model.APIProvisioning;
import java.util.List;

public interface IAPIProvisioningService {
    
    public List<APIProvisioning> getAllAPIProvisioning();

    public APIProvisioning getAPIProvisioningById(String id);
    
    public void insertAPIProvisioning(APIProvisioning mAPIProvisioning);

    public void updateAPIProvisioning(APIProvisioning mAPIProvisioning);

    public void deleteAPIProvisioning(String Id);
   
}

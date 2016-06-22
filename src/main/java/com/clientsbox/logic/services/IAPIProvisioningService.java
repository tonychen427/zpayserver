
package com.clientsbox.logic.services;

import com.clientsbox.core.model.APIProvisioning;
import java.util.List;

public interface IAPIProvisioningService {
    
    public List<APIProvisioning> getAllAPIProvisioning();

    public APIProvisioning getAPIProvisioningById(String id);
    
    public String insertAPIProvisioning(APIProvisioning mAPIProvisioning);

    public APIProvisioning updateAPIProvisioning(String id, APIProvisioning mAPIProvisioning);

    public boolean deleteAPIProvisioning(String Id);
   
}

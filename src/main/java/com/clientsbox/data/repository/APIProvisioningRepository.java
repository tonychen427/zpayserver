package com.clientsbox.data.repository;

import com.clientsbox.core.constant.SystemInfo;
import java.util.List;
import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.RepositoryBase;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

@Repository
public class APIProvisioningRepository extends RepositoryBase implements IAPIProvisioningRepository {

    @Override
    public List<APIProvisioning> getAllAPIProvisioning(UserSession mUserSession) {
        return this.getAllRepository(mUserSession, SystemInfo.DbNameApiProvisioning, APIProvisioning.class);
    }

    @Override
    public APIProvisioning getAPIProvisioningById(String id, UserSession mUserSession) {
        return this.getRepositoryById(id, mUserSession, SystemInfo.DbNameApiProvisioning, APIProvisioning.class);
    }

    @Override
    public String insertAPIProvisioning(APIProvisioning mAPIProvisioning, UserSession mUserSession) {
        return this.insertRepository(mAPIProvisioning, mUserSession, SystemInfo.DbNameApiProvisioning);
    }

    @Override
    public APIProvisioning updateAPIProvisioning(String id, APIProvisioning mAPIProvisioning, UserSession mUserSession) {
        return this.updateRepository(id, mAPIProvisioning, mUserSession, SystemInfo.DbNameApiProvisioning);
    }

    @Override
    public boolean deleteAPIProvisioning(String Id, UserSession mUserSession) {
        return this.deleteRepository(Id, mUserSession, SystemInfo.DbNameApiProvisioning);
    }

    @Override
    protected <T> T mapListRepository(String id, String mValue) {
        Gson gson = new Gson();
        APIProvisioning mAPIProvisioning = gson.fromJson(mValue, APIProvisioning.class);
        mAPIProvisioning.setId(id);
        return (T) mAPIProvisioning;
    }

}

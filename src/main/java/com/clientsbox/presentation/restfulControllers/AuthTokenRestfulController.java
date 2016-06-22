package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IAPIProvisioningService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthTokenRestfulController {

    @Autowired
    IAPIProvisioningService _APIProvisioningService;

    @RequestMapping(value = "/requestToken", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserList(@RequestHeader("Authorization") String authValue) {

        APIProvisioning mAPIProvisioning = new APIProvisioning();
        mAPIProvisioning.setUserId(UUID.randomUUID().toString());
        mAPIProvisioning.setAuthorizationKey(UUID.randomUUID().toString());
        String apiId = _APIProvisioningService.insertAPIProvisioning(mAPIProvisioning);
        APIProvisioning mAPIProvisioningRecord = _APIProvisioningService.getAPIProvisioningById(apiId);
        List<APIProvisioning> mAPIProvisioningList = _APIProvisioningService.getAllAPIProvisioning();

    
        mAPIProvisioningRecord.setUserId(UUID.randomUUID().toString());
        mAPIProvisioningRecord.setAuthorizationKey(UUID.randomUUID().toString());

        APIProvisioning mUpdate = _APIProvisioningService.updateAPIProvisioning(apiId, mAPIProvisioningRecord);
        boolean mDelete = _APIProvisioningService.deleteAPIProvisioning(apiId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

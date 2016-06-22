package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IAPIProvisioningService;
import com.clientsbox.logic.services.IUserAccessTokenService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthTokenRestfulController {

    @Autowired
    IAPIProvisioningService _APIProvisioningService;
    @Autowired
    IUserAccessTokenService _userAccessTokenService;

    @RequestMapping(value = "/requestToken/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserList(@RequestHeader("Authorization") String authValue, @PathVariable("userId") String userId, @RequestBody User mUser) {
        UserSession mUserSession = new UserSession();
        
        
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

    public void testing() {
        APIProvisioning mAPIProvisioning = new APIProvisioning();
        mAPIProvisioning.setCreateDateTime(UUID.randomUUID().toString());
        mAPIProvisioning.setAuthorizationKey(UUID.randomUUID().toString());
        String apiId = _APIProvisioningService.insertAPIProvisioning(mAPIProvisioning);
        APIProvisioning mAPIProvisioningRecord = _APIProvisioningService.getAPIProvisioningById(apiId);
        List<APIProvisioning> mAPIProvisioningList = _APIProvisioningService.getAllAPIProvisioning();

        mAPIProvisioningRecord.setCreateDateTime(UUID.randomUUID().toString());
        mAPIProvisioningRecord.setAuthorizationKey(UUID.randomUUID().toString());

        APIProvisioning mUpdate = _APIProvisioningService.updateAPIProvisioning(apiId, mAPIProvisioningRecord);
        boolean mDelete = _APIProvisioningService.deleteAPIProvisioning(apiId);
    }
}

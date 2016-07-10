//https://code.exacttarget.com/apis-sdks/rest-api/using-the-api-key-to-authenticate-api-calls.html
package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserAccessToken;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IAPIProvisioningService;
import com.clientsbox.logic.services.IUserAccessTokenService;
import com.clientsbox.logic.services.IUserService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccessTokenRestfulController {

    @Autowired
    IAPIProvisioningService _APIProvisioningService;

    @Autowired
    IUserService _userService;

    @Autowired
    IUserAccessTokenService _userAccessTokenService;

    @RequestMapping(value = "/requestToken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserList(@RequestHeader("Authorization") String apiKey, @RequestBody UserAccessToken mToken) {

        UserSession mUserSession = new UserSession();

        UserAccessToken mAccessToken = _userAccessTokenService.getUserAccessTokenbyUserIdDeviceId(apiKey, mToken.getUserId(), mToken.getDeviceUniqueId(), mToken.getFcmPushToken());
        mUserSession.setTargetURL("/api/requestToken");
        mUserSession.setApiKey(apiKey);
        mUserSession.setAccessToken(mAccessToken.getAccessToken());
        mUserSession.setData("");
        mUserSession.setStatus(HttpStatus.OK);
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

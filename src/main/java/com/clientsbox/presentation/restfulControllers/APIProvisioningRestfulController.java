package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.APIProvisioning;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IAPIProvisioningService;
import com.clientsbox.logic.services.IUserAccessTokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIProvisioningRestfulController {

//    @Autowired
//    IUserService _userServices;
    @Autowired
    IAPIProvisioningService _APIProvisioningService;

    @Autowired
    IUserAccessTokenService _userAccessTokenService;

    @RequestMapping(value = "/APIProvisionings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getAPIProvisioningList() {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/APIProvisionings");
        mUserSession.setApiKey(SystemInfo.authorizationKey);

        List<APIProvisioning> mAPIProvisioningList = _APIProvisioningService.getAllAPIProvisioning();
        mUserSession.setData(mAPIProvisioningList);
        mUserSession.setStatus(HttpStatus.OK);
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

    @RequestMapping(value = "/APIProvisioning/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getAPIProvisioningById(@PathVariable("id") String id) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/APIProvisioning/" + id);        
        mUserSession.setApiKey(SystemInfo.authorizationKey);

        APIProvisioning mAPIProvisioning = _APIProvisioningService.getAPIProvisioningById(id);
        mUserSession.setData(mAPIProvisioning);
        mUserSession.setStatus(HttpStatus.OK);
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

    @RequestMapping(value = "/APIProvisioning", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> insertAPIProvisioning(@RequestBody APIProvisioning mAPIProvisioning) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/APIProvisioning");
        mUserSession.setApiKey(SystemInfo.authorizationKey);

        String userId = _APIProvisioningService.insertAPIProvisioning(mAPIProvisioning);
        mUserSession.setStatus(HttpStatus.CREATED);
        return new ResponseEntity<>(mUserSession, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/APIProvisioning/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> updateAPIProvisioning(@PathVariable("id") String id, @RequestBody APIProvisioning mAPIProvisioning) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/APIProvisioning/" + id);
        mUserSession.setApiKey(SystemInfo.authorizationKey);

        APIProvisioning updateData = _APIProvisioningService.updateAPIProvisioning(id, mAPIProvisioning);
        mUserSession.setData(updateData);
        mUserSession.setStatus(HttpStatus.OK);
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

    @RequestMapping(value = "/APIProvisioning/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> deleteAPIProvisioning(@PathVariable("id") String id) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/APIProvisioning/" + id);
        mUserSession.setApiKey(SystemInfo.authorizationKey);

        if (_APIProvisioningService.deleteAPIProvisioning(id)) {
            mUserSession.setStatus(HttpStatus.OK);
            return new ResponseEntity<>(mUserSession, HttpStatus.OK);
        } else {
            mUserSession.setStatus(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(mUserSession, HttpStatus.NOT_FOUND);
        }
    }
}

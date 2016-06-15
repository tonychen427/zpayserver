package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IAPIProvisioningService;
import com.clientsbox.logic.services.IUserService;
import java.util.List;
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
public class UserRestfulController {

    @Autowired
    IUserService _userServices;
    
    @Autowired
    IAPIProvisioningService _APIProvisioningService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserList(@RequestHeader("Authorization") String apiKey) {
        if (apiKey.equals(SystemInfo.authorizationKey)) {
            return new ResponseEntity<>(_userServices.getUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserById(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id) {
        if (apiKey.equals(SystemInfo.authorizationKey)) {
            return new ResponseEntity<>(_userServices.getUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> insertUser(@RequestHeader("Authorization") String apiKey, @RequestBody User mUser) {
        if (apiKey.equals(SystemInfo.authorizationKey)) {
            _userServices.insertUser(mUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id, @RequestBody User mUser) {
        if (apiKey.equals(SystemInfo.authorizationKey)) {
            mUser.setId(apiKey);
            _userServices.updateUser(mUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id) {
        if (apiKey.equals(SystemInfo.authorizationKey)) {
            _userServices.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/userSession/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserSession(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserSession mUserSession = new UserSession();
        
        mUserSession.setUserId(username+password);
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);
        /*
        APIProvisioning mAPIProvisioning = _APIProvisioningService.getAPIProvisioningInfoByUsernamePassword(username, password);
        mUserSession.setUserId(mAPIProvisioning.getUserId());
        mUserSession.setAuthorizationKey(mAPIProvisioning.getAuthorizationKey());
        */
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

}

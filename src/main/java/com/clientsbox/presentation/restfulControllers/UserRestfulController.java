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
    public ResponseEntity<UserSession> getUserList(@RequestHeader("Authorization") String apiKey) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/users");
        mUserSession.setUserId("");
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);

        if (apiKey.equals(SystemInfo.authorizationKey)) {
            List<User> mUserList = _userServices.getUsers();
            mUserSession.setData(mUserList);
            mUserSession.setStatus(HttpStatus.OK);
            return new ResponseEntity<>(mUserSession, HttpStatus.OK);
        } else {
            mUserSession.setStatus(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserById(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/user/" + id);
        mUserSession.setUserId(id);
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);

        if (apiKey.equals(SystemInfo.authorizationKey)) {
            User mUser = _userServices.getUserById(id);
            mUserSession.setData(mUser);
            mUserSession.setStatus(HttpStatus.OK);
            return new ResponseEntity<>(mUserSession, HttpStatus.OK);
        } else {
            mUserSession.setStatus(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> insertUser(@RequestHeader("Authorization") String apiKey, @RequestBody User mUser) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/user");
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);

        if (apiKey.equals(SystemInfo.authorizationKey)) {
            String userId = _userServices.insertUser(mUser);
            mUserSession.setUserId(userId);
            mUserSession.setStatus(HttpStatus.CREATED);
            return new ResponseEntity<>(mUserSession, HttpStatus.CREATED);
        } else {
            mUserSession.setStatus(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(mUserSession, HttpStatus.UNAUTHORIZED);
        }

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> updateUser(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id, @RequestBody User mUser) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/user/" + id);
        mUserSession.setUserId(id);
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);

        if (apiKey.equals(SystemInfo.authorizationKey)) {
            User updateData = _userServices.updateUser(id, mUser);
            mUserSession.setData(updateData);                   
            mUserSession.setStatus(HttpStatus.OK);
            return new ResponseEntity<>(mUserSession, HttpStatus.OK);
        } else {
            mUserSession.setStatus(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(mUserSession, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> deleteUser(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id) {

        UserSession mUserSession = new UserSession();
        mUserSession.setTargetURL("/api/user/" + id);
        mUserSession.setUserId(id);
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);

        if (apiKey.equals(SystemInfo.authorizationKey)) {
            if (_userServices.deleteUser(id)) {
                mUserSession.setStatus(HttpStatus.OK);
                return new ResponseEntity<>(mUserSession, HttpStatus.OK);
            } else {
                mUserSession.setStatus(HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(mUserSession, HttpStatus.NOT_FOUND);
            }
        } else {
            mUserSession.setStatus(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(mUserSession, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/userSession/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserSession(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserSession mUserSession = new UserSession();

        mUserSession.setUserId(username + password);
        mUserSession.setAuthorizationKey(SystemInfo.authorizationKey);

        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

}

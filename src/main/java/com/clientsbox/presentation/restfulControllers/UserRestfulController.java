package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IUserService;
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
public class UserRestfulController {

    @Autowired
    IUserService _userServices;
      @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserList() {
       
       return new ResponseEntity<>(_userServices.getUsers(), HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/user/{id}/userSession", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserSession(@PathVariable("id") String id) {
        UserSession mUserSession = new UserSession();
        mUserSession.setAccessToken(UUID.randomUUID().toString());
        mUserSession.setUserId(id);
        if (mUserSession == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> getUserLogin(@RequestBody User mUser ) {
        
        UserSession mUserSession = _userServices.getUserSessionByUsernamePassword(mUser);
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);        
    }
    
    @RequestMapping(value = "/user/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> registerUser(@RequestBody User mUser ) {
        
        UserSession mUserSession = _userServices.registerUser(mUser);
        return new ResponseEntity<>(mUserSession, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/{id}/gcmRegistrationId", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGCMRegistrationByUserId(@PathVariable("id") String id, @RequestHeader(value="accessToken") String accessToken, @RequestBody String GCMRegistrationId ) {
        
        _userServices.updateGCMRegistrationIdByUserId(id, GCMRegistrationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

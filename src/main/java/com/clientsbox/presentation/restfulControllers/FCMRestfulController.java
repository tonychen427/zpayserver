package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.logic.services.IFCMService;
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
public class FCMRestfulController {

    @Autowired
    IFCMService _fcmService;

    @RequestMapping(value = "/fcm/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSession> sendFireBaseMessage(@RequestHeader("Authorization") String apiKey, @PathVariable("id") String id, @RequestBody FirebaseCloudMessage mFirebaseCloudMessage) {
        UserSession mUserSession = new UserSession();        
        if (apiKey.equals(SystemInfo.authorizationKey)) {
           
            
            
            mUserSession.setStatus(HttpStatus.OK);
            return new ResponseEntity<>(mUserSession, HttpStatus.OK);
        } else {
            mUserSession.setStatus(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(mUserSession, HttpStatus.UNAUTHORIZED);
        }
    }
}

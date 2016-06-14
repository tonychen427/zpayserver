package com.clientsbox.presentation.restfulControllers;

import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.logic.services.IFCMService;
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
public class FCMRestfulController {

    @Autowired
    IFCMService _fcmService;

    @RequestMapping(value = "/fcm/{authorizationKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> SendFirebaseCloudMessage(@PathVariable("authorizationKey") String authorizationKey, @RequestBody FirebaseCloudMessage mFirebaseCloudMessage) {
        boolean successful =  _fcmService.SendDownstreamMessage(mFirebaseCloudMessage, authorizationKey);
        
        return new ResponseEntity<>(successful, HttpStatus.OK);
    }
}

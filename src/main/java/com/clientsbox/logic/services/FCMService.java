/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.clientsbox.core.model.CloudMessage;
import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.core.model.FirebaseCloudMessage.data;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.IFCMRepository;
import com.clientsbox.data.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FCMService implements IFCMService {

    @Autowired
    IFCMRepository _fcmRepository;

    @Autowired
    IUserRepository _userRepository;

    @Override
    public boolean SendDownstreamMessage(CloudMessage mCloudMessage) {

        UserSession mUserSession = new UserSession();
//        String mFromUserDeviceId = _userRepository.getUserById(mCloudMessage.getFromUserId(), mUserSession).getFcm_deviceRegId();
//        String mSendUserDeviceId = _userRepository.getUserById(mCloudMessage.getSendUserId(), mUserSession).getFcm_deviceRegId();

        String mFromUserDeviceId = mCloudMessage.getFromUserId();
        String mSendUserDeviceId = mCloudMessage.getSendUserId();

        FirebaseCloudMessage mFirebaseCloudMessage = new FirebaseCloudMessage();

        data mData = new data();
        mData.setMessage(mCloudMessage.getData());

        mFirebaseCloudMessage.setTo(mSendUserDeviceId);
        mFirebaseCloudMessage.setData(mData);
        String successful = _fcmRepository.SendDownstreamMessage(mFirebaseCloudMessage, mUserSession);
        return successful.toLowerCase().equals("success");
    }

}

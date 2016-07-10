package com.clientsbox.logic.services;

import com.clientsbox.core.model.CloudMessage;
import com.clientsbox.core.model.Log;
import com.clientsbox.core.model.UserAccessToken;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.ILogRepository;
import com.clientsbox.data.repository.IUserAccessTokenRepository;
import com.clientsbox.logic.services.helper.xMatcherHelper;
import com.clientsbox.logic.services.helper.xMatcherHelper.XMatcher;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccessTokenService extends xMatcherHelper implements IUserAccessTokenService {

    @Autowired
    IAPIProvisioningService _APIProvisioningService;

    @Autowired
    IUserAccessTokenRepository _userAccessTokenRepository;

    @Autowired
    IFCMService _fcmService;

    @Autowired
    ILogRepository _LogRepository;

    @Override
    public List<UserAccessToken> getUserAccessTokenList() {
        UserSession mUserSession = new UserSession();
        return _userAccessTokenRepository.getAllUserAccessTokens(mUserSession);
    }

    @Override
    public UserAccessToken getUserAccessTokenById(String id) {
        UserSession mUserSession = new UserSession();
        return _userAccessTokenRepository.getUserAccessTokenById(id, mUserSession);
    }

    @Override
    public String insertUserAccessToken(UserAccessToken mUserAccessToken) {
        UserSession mUserSession = new UserSession();
        return _userAccessTokenRepository.insertUserAccessToken(mUserAccessToken, mUserSession);
    }

    @Override
    public UserAccessToken updateUserAccessToken(String id, UserAccessToken mUserAccessToken) {
        UserSession mUserSession = new UserSession();
        return _userAccessTokenRepository.updateUserAccessToken(id, mUserAccessToken, mUserSession);
    }

    @Override
    public boolean deleteUserAccessToken(String id) {
        UserSession mUserSession = new UserSession();
        return _userAccessTokenRepository.deleteUserAccessToken(id, mUserSession);
    }

    @Override
    public UserAccessToken getUserAccessTokenbyUserIdDeviceId(final String mAPIKey, final String mUserId, final String mDeviceId, final String mFCMPushToken) {
        final UserSession mUserSession = new UserSession();
        boolean isUserIdFound = false;
        boolean isDeviceIdFound = false;

        List<UserAccessToken> mUserAccessToken = _userAccessTokenRepository.getAllUserAccessTokens(mUserSession);

        List<UserAccessToken> searchAllMatchToken = searchIn(mUserAccessToken, new XMatcher<UserAccessToken>() {
            @Override
            public boolean xmatches(UserAccessToken t) {
                boolean found = false;
                if (t.getUserId().equals(mUserId)) {
                    if (!(t.getDeviceUniqueId().equals(mDeviceId))) {

                        //send fcm to logoff user
                        CloudMessage mCloudMessage = new CloudMessage();
                        mCloudMessage.setFromUserId(mFCMPushToken);
                        mCloudMessage.setSendUserId(t.getFcmPushToken());
                        mCloudMessage.setData("{ 'task' : 'logoff' , 'deviceId' : '" + t.getDeviceUniqueId() + "' }");

                        _fcmService.SendDownstreamMessage(mCloudMessage);
                        _userAccessTokenRepository.deleteUserAccessToken(t.getId(), mUserSession);
                    } else {
                        found = true;
                    }
                }
                return found;
            }
        });

        UserAccessToken mToken;
        if (searchAllMatchToken.size() > 0) {
            mToken = searchAllMatchToken.get(0);
            mToken.setAccessToken(UUID.randomUUID().toString());
            _userAccessTokenRepository.updateUserAccessToken(mToken.getId(), mToken, mUserSession);
        } else {
            mToken = new UserAccessToken();
            mToken.setApiKey(mAPIKey);
            mToken.setUserId(mUserId);
            mToken.setDeviceUniqueId(mDeviceId);
            mToken.setFcmPushToken(mFCMPushToken);
            mToken.setAccessToken(UUID.randomUUID().toString());

            _userAccessTokenRepository.insertUserAccessToken(mToken, mUserSession);
        }

        return mToken;
    }

    @Override
    public List<UserAccessToken> getAccessToken(final String mAccessTokenValid) {
        final UserSession mUserSession = new UserSession();

        List<UserAccessToken> mUserAccessToken = _userAccessTokenRepository.getAllUserAccessTokens(mUserSession);

        List<UserAccessToken> searchAllMatchToken = searchIn(mUserAccessToken, new XMatcher<UserAccessToken>() {

            @Override
            public boolean xmatches(UserAccessToken t) {
                String mFullToken = "Bearer " + t.getAccessToken();
                return mFullToken.equals(mAccessTokenValid);
            }

        });

        return searchAllMatchToken;

//        if (searchAllMatchToken.size() > 0) {
//            return true;
//        } else {
///*            send fcm to logoff user*/
////            CloudMessage mCloudMessage = new CloudMessage();
////            mCloudMessage.setSendUserId(mUserId);
////            mCloudMessage.setData("{ 'task' : 'logoff' , 'deviceId' : '" + mDeviceId + "' }");
////            _fcmService.SendDownstreamMessage(mCloudMessage);
//            return false;
//        }
    }

}

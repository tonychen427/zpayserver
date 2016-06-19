/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.FirebaseCloudMessage;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.HttpConnectionHelper;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class FCMRepository extends HttpConnectionHelper implements IFCMRepository {

    @Override
    public String SendDownstreamMessage(FirebaseCloudMessage mFirebaseCloudMessage, UserSession mUserSession) {
        Gson gson = new Gson();
        String mData = gson.toJson(mFirebaseCloudMessage);

        mUserSession.setTargetURL(SystemInfo.firebaseFCMUrl);

        try {
            mUserSession.setData(mData);
            String returnData = this.sendPost(mUserSession);
            JSONObject jsonObj = new JSONObject(returnData);
            String multicast_id = jsonObj.getString("multicast_id");
            return multicast_id;
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}

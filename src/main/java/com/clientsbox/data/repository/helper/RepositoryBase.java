/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository.helper;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.UserRepository;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RepositoryBase extends HttpConnectionHelper {

    public <T> List<T> getAllRepository(UserSession mUserSession, String dbName, Class<T> clazz) {
        mUserSession.setTargetURL(SystemInfo.firebaseDatabaseUrl + "/" + dbName + ".json");
        String result = this.sendGet(mUserSession);
        List<T> mRepositoryList = new ArrayList<>();
        JSONObject UserJsonObj;
        try {
            UserJsonObj = new JSONObject(result);

            for (int i = 0; i < UserJsonObj.names().length(); i++) {
                String data = "key = " + UserJsonObj.names().getString(i) + " value = " + UserJsonObj.get(UserJsonObj.names().getString(i));
                String mKey = UserJsonObj.names().getString(i);
                String mValue = UserJsonObj.get(UserJsonObj.names().getString(i)).toString();
                T mUser = mapListRepository(mKey, mValue);

                mRepositoryList.add((T) mUser);
            }
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mRepositoryList;
    }

    public <T> T getRepositoryById(String id, UserSession mUserSession, String dbName, Class<T> clazz) {

        mUserSession.setTargetURL(SystemInfo.firebaseDatabaseUrl + "/" + dbName + "/" + id + ".json");
        String result = this.sendGet(mUserSession);
        T mRepository = mapListRepository(id, result);

        return mRepository;

    }

    public String insertRepository(Object mRepository, UserSession mUserSession, String dbName) {
        Gson gson = new Gson();
        String mData = gson.toJson(mRepository);

        mUserSession.setTargetURL(SystemInfo.firebaseDatabaseUrl + "/" + dbName + ".json");

        try {
            JSONArray array = new JSONArray("[" + mData + "]");
            mUserSession.setData(array.getJSONObject(0));
            String returnData = this.sendPost(mUserSession);
            JSONObject jsonObj = new JSONObject(returnData);
            String repositoryId = jsonObj.getString("name");
            return repositoryId;
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public <T> T updateRepository(String id, Object mRepository, UserSession mUserSession, String dbName) {
        Gson gson = new Gson();
        String mData = gson.toJson(mRepository);
        mUserSession.setTargetURL(SystemInfo.firebaseDatabaseUrl + "/" + dbName + "/" + id + ".json");
        try {
            JSONArray array = new JSONArray("[" + mData + "]");
            mUserSession.setData(array.getJSONObject(0));
            String returnData = this.setPut(mUserSession);
            T mUpdateRepository = mapListRepository(id, returnData);

            return mUpdateRepository;
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deleteRepository(String id, UserSession mUserSession, String dbName) {
        mUserSession.setTargetURL(SystemInfo.firebaseDatabaseUrl + "/" + dbName + "/" + id + ".json");
        return this.sendDelete(mUserSession) == HttpURLConnection.HTTP_OK;
    }

    protected abstract <T> T mapListRepository(String id, String mValue);

}

package com.clientsbox.data.repository;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.HttpConnectionHelper;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends HttpConnectionHelper implements IUserRepository {

    
    
    @Override
    public List<User> getAllUsers(UserSession mUserSession) {
        mUserSession.setTargetURL(SystemInfo.databaseUrl + "/users.json");
        String result = this.sendGet(mUserSession);

        Gson gson = new Gson();
        List<User> mUserList = new ArrayList<>();

        JSONObject UserJsonObj;
        try {
            UserJsonObj = new JSONObject(result);

            for (int i = 0; i < UserJsonObj.names().length(); i++) {
                String data = "key = " + UserJsonObj.names().getString(i) + " value = " + UserJsonObj.get(UserJsonObj.names().getString(i));
                String mKey = UserJsonObj.names().getString(i);
                String mValue = UserJsonObj.get(UserJsonObj.names().getString(i)).toString();
                User mUser = gson.fromJson(mValue, User.class);
                mUser.setId(mKey);
                mUserList.add(mUser);
            }
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mUserList;
    }

    @Override
    public User getUserById(String id, UserSession mUserSession) {

        Gson gson = new Gson();
        mUserSession.setTargetURL(SystemInfo.databaseUrl + "/users/" + id + ".json");
        String result = this.sendGet(mUserSession);
        User mUser = gson.fromJson(result, User.class);
        mUser.setId(id);
        return mUser;

    }

    @Override
    public String insertUser(User mUser, UserSession mUserSession) {
        Gson gson = new Gson();
        String mData = gson.toJson(mUser);

        mUserSession.setTargetURL(SystemInfo.databaseUrl + "/users.json");

        try {
            JSONArray array = new JSONArray("[" + mData + "]");
            mUserSession.setData(array.getJSONObject(0));
            String returnData = this.sendPost(mUserSession);
            JSONObject jsonObj = new JSONObject(returnData);
            String userId = jsonObj.getString("name");
            return userId;
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User updateUser(User mUser, UserSession mUserSession) {
        Gson gson = new Gson();
        String mData = gson.toJson(mUser);
        mUserSession.setTargetURL(SystemInfo.databaseUrl + "/users/" + mUser.getId() + ".json");
        try {
            JSONArray array = new JSONArray("[" + mData + "]");
            mUserSession.setData(array.getJSONObject(0));
            String returnData = this.setPut(mUserSession);
            User mUpdateUser = gson.fromJson(returnData, User.class);  
            mUpdateUser.setId(mUser.getId());
            return mUpdateUser;
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   

    @Override
    public boolean deleteUser(String id, UserSession mUserSession) {
        mUserSession.setTargetURL(SystemInfo.databaseUrl + "/users/" + id + ".json");
        return this.sendDelete(mUserSession) == HttpURLConnection.HTTP_OK;
    }

}

package com.clientsbox.data.repository;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.HttpConnectionHelper;
import com.google.gson.Gson;
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
        mUserSession.setTargetURL("https://zpayworld-1339.firebaseio.com/Users.json");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertUser(User mUser, UserSession mUserSession) {
        Gson gson = new Gson();
        String mData = gson.toJson(mUser);
        
        mUserSession.setTargetURL("https://zpayworld-1339.firebaseio.com/Users.json");
        
        try {
            JSONArray array = new JSONArray("[" + mData + "]");

            return this.sendPost(mUserSession, array.getJSONObject(0));
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateUser(User mUser, UserSession mUserSession) {
         Gson gson = new Gson();
        String mData = gson.toJson(mUser);

        try {
            JSONArray array = new JSONArray("[" + mData + "]");

            //this.sendPut("https://zpayworld-1339.firebaseio.com/Users/" + mUser.id +".json", array.getJSONObject(0));
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUser(String id, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserInfoByUsernamePassword(String mUsername, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

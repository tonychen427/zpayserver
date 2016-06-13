package com.clientsbox.data.repository;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.HttpConnectionHelper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends HttpConnectionHelper implements IUserRepository {

    @Override
    public List<User> getAllUsers(UserSession mUserSession) {

        String jsonStr = "[  "
                + " {"
                + "   \"data\": {"
                + "       \"title\": \"Test Title\","
                + "       \"body\": \"hello\""
                + "   },"
                + " }]";

        try {
            JSONArray array = new JSONArray(jsonStr);
            this.sendPost("https://zpayworld-1339.firebaseio.com/Users.json", array.getJSONObject(0));
        } catch (JSONException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        String resutl = this.sendGet("https://zpayworld-1339.firebaseio.com/Users.json");

        List<User> mUserList;
        mUserList = new ArrayList<>();
        User mUser = new User();
        mUser.setUsername(resutl);
        mUserList.add(mUser);
        return mUserList;
    }

    @Override
    public User getUserById(String id, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUser(User mUser, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(User mUser, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(User mUser, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

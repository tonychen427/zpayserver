package com.clientsbox.data.repository;

import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    @Override
    public List<User> getAllUsers(UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        ClassLoader classLoader = getClass().getClassLoader();
        String Url = classLoader.getResource("serviceAccountCredentials.json").getPath();

        try {
            FirebaseOptions options;
            options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream(Url))
                    .setDatabaseUrl("https://zpay-4b5d6.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("oAuthRecord/");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot ds) {
                Object document = ds.getValue();
                System.out.println(document);
            }

            @Override
            public void onCancelled(DatabaseError de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        

    }

    @Override
    public void deleteUser(User mUser, UserSession mUserSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import java.util.List;
import com.clientsbox.core.model.APIProvisioning;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;

@Repository
public class APIProvisioningRepository implements IAPIProvisioningRepository{
    
    public static final String firebaseRealtimeDatabaseUrl = "https://zpayworld-1339.firebaseio.com/APIProvisioning.json";
    
    
    @Override
    public List<APIProvisioning> getAllAPIProvisioning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public APIProvisioning getAPIProvisioningById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAPIProvisioning(APIProvisioning mAPIProvisioning) {
                
        HttpURLConnection connection = null;
        try {
            URL url = new URL(firebaseRealtimeDatabaseUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");            
            OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
            
            Gson gson = new Gson();
            String mData = gson.toJson(mAPIProvisioning);
            JSONArray array = new JSONArray("[" + mData + "]");            
            streamWriter.write(array.getJSONObject(0).toString());
            streamWriter.flush();
            StringBuilder stringBuilder = new StringBuilder();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                try (BufferedReader bufferedReader = new BufferedReader(streamReader)) {
                    String response;
                    while ((response = bufferedReader.readLine()) != null) {
                        stringBuilder.append(response).append("\n");
                    }
                    bufferedReader.close();

                    //Log.d("test", stringBuilder.toString());
                    //return stringBuilder.toString();
                }
            } else {
                //Log.e("test", connection.getResponseMessage());
                //return null;
            }
        } catch (Exception exception) {
            //Log.e("test", exception.toString());
            //return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        
    }

    @Override
    public void updateAPIProvisioning(APIProvisioning mAPIProvisioning) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAPIProvisioning(String Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

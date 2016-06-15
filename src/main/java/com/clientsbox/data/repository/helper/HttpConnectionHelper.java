/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository.helper;

import com.clientsbox.core.model.UserSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class HttpConnectionHelper {

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    protected String sendGet(UserSession mUserSession) {

        HttpURLConnection connection = null;
        StringBuilder response;
        try {
            //Create connection
            URL url = new URL(mUserSession.getTargetURL());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            InputStream is = connection.getInputStream();
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
                response = new StringBuilder(); // or StringBuffer if not Java 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
            } // or StringBuffer if not Java 5+

        } catch (Exception e) {
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response.toString();
    }

    protected String sendPost(UserSession mUserSession, JSONObject json) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(mUserSession.getTargetURL());
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            //connection.setRequestProperty("Authorization", "key=" + gcm.getGcmAPIKey());
            OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
            streamWriter.write(json.toString());
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
                    return stringBuilder.toString();
                }
            } else {
                //Log.e("test", connection.getResponseMessage());
                return null;
            }
        } catch (Exception exception) {
            //Log.e("test", exception.toString());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}

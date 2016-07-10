/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import com.clientsbox.core.constant.SystemInfo;
import com.clientsbox.core.model.Log;
import com.clientsbox.core.model.User;
import com.clientsbox.core.model.UserSession;
import com.clientsbox.data.repository.helper.RepositoryBase;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository extends RepositoryBase implements ILogRepository{

    @Override
    protected <T> T mapListRepository(String id, String mValue) {
        Gson gson = new Gson();
        Log mUser = gson.fromJson(mValue, Log.class);
        mUser.setId(id);
        return (T) mUser;
    }

    @Override
    public void InsertLogs(Log mLogs, UserSession mUserSession) {
         this.insertRepository(mLogs, mUserSession, SystemInfo.DbNameLogs);
    }    
}

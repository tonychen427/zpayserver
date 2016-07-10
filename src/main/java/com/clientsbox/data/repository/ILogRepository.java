/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import com.clientsbox.core.model.Log;
import com.clientsbox.core.model.UserSession;

public interface ILogRepository {
    
    public void InsertLogs(Log mLogs, UserSession mUserSession);
}

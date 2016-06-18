/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import java.io.ByteArrayOutputStream;

/**
 *
 * @author ttran
 */
public interface IQRCodeRepository {
    
    public ByteArrayOutputStream getQRCode(String mText, int width, int height );
}

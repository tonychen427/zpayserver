/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService implements IQRCodeService {

    @Autowired
    IEncryptorService _encryptorService;
    
    @Override
    public ByteArrayOutputStream getQRCodeBytesStream(String text) {

        String encryptQRCodeTxt = "";
        try {
            encryptQRCodeTxt = _encryptorService.encryptCode(text);            
        } catch (Exception ex) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).withColor(0xFFFF0000, 0xFFFFFFAA).stream();
        return stream;
    }

   
}

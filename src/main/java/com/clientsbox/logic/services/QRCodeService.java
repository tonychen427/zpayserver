/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.clientsbox.data.repository.IQRCodeRepository;
import com.google.code.appengine.awt.Graphics2D;
import com.google.code.appengine.awt.image.BufferedImage;
import com.google.code.appengine.awt.image.RenderedImage;
import com.google.code.appengine.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService implements IQRCodeService {

    @Autowired
    IEncryptorService _encryptorService;

    @Autowired
    IQRCodeRepository _qrCodeRepository;

    @Override
    public byte[] getQRCodeBytesStream(String text) {

        String encryptQRCodeTxt = "";
        try {
            encryptQRCodeTxt = _encryptorService.encryptCode(text);
        } catch (Exception ex) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        ByteArrayOutputStream baos = _qrCodeRepository.getQRCode(text, 250, 250);

        return baos.toByteArray();
    }
}

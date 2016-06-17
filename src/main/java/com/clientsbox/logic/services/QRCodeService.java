/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.logic.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import static com.google.zxing.client.j2se.MatrixToImageConfig.BLACK;
import static com.google.zxing.client.j2se.MatrixToImageConfig.WHITE;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import static com.google.zxing.client.j2se.MatrixToImageWriter.writeToStream;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService implements IQRCodeService {

    @Autowired
    IEncryptorService _encryptorService;

    @Override
    public byte[] getQRCodeBytesStream(String text) {

        String encryptQRCodeTxt = "";
        try {
            encryptQRCodeTxt = _encryptorService.encryptCode(text);
        } catch (Exception ex) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BitMatrix result = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 400, 400);

            int width = result.getWidth();
            int height = result.getHeight();
            byte[] pixels = new byte[width * height];
            // All are 0, or black, by default
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    pixels[offset + x] = (byte) (result.get(x, y) ? BLACK : WHITE);
                }
            }

            return pixels;
        } catch (WriterException ex) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, ex);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            return stream.toByteArray();
        }
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();

        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
        //ByteArrayOutputStream stream = QRCode.from(encryptQRCodeTxt).stream();
    }

}

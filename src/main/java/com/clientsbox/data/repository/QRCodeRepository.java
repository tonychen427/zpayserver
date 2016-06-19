/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.data.repository;

import com.clientsbox.logic.services.QRCodeService;
import com.google.code.appengine.awt.AlphaComposite;
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
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class QRCodeRepository implements IQRCodeRepository {

    @Override
    public ByteArrayOutputStream getQRCode(String mText, int width, int height) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // create an empty image
        int white = 255 << 16 | 255 << 8 | 255;
        int black = 0;
        try {

            BitMatrix bitMatrix = new QRCodeWriter().encode(mText, BarcodeFormat.QR_CODE, width, height);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    image.setRGB(i, j, bitMatrix.get(i, j) ? black : white); // set pixel one by one
                }
            }

            Graphics2D bImageGraphics = image.createGraphics();

            //draw the Image (image) into the BufferedImage (bImage)
            bImageGraphics.drawImage(image, null, null);

            // cast it to rendered image
            RenderedImage rImage = (RenderedImage) image;

            ImageIO.write(rImage, "png", baos);

            return baos;

        } catch (WriterException | IOException e) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public ByteArrayOutputStream getQRCodeWithLogo(String mText, int width, int height) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        BufferedImage qrImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // create an empty image
        int white = 255 << 16 | 255 << 8 | 255;
        int black = 0;
        try {

            BitMatrix bitMatrix = new QRCodeWriter().encode(mText, BarcodeFormat.QR_CODE, width, height);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    qrImage.setRGB(i, j, bitMatrix.get(i, j) ? black : white); // set pixel one by one
                }
            }
        } catch (WriterException e) {
            Logger.getLogger(QRCodeService.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

        try {
            InputStream im = this.getClass().getResourceAsStream("/zPayLogo7.png");
            BufferedImage logoImage = ImageIO.read(im);

            int deltaHeight = qrImage.getHeight() - logoImage.getHeight();
            int deltaWidth = qrImage.getWidth() - logoImage.getWidth();

            // Initialize combined image
            BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = (Graphics2D) combined.getGraphics();

            // Write QR code to new image at position 0/0
            g.drawImage(qrImage, 0, 0, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // Write logo into combine image at position (deltaWidth / 2) and
            // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
            // the same space for the logo to be centered
            g.drawImage(logoImage, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);

            // Write combined image as PNG to OutputStream
            ImageIO.write(combined, "png", baos);
            
            return baos;
        } catch (IOException ex) {
            Logger.getLogger(QRCodeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}

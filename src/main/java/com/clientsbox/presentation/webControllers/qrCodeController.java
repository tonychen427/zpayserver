/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientsbox.presentation.webControllers;

import com.clientsbox.logic.services.IQRCodeService;
import java.io.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class qrCodeController {
    
    @Autowired
    IQRCodeService _qrCodeService;

    @ResponseBody
    @RequestMapping(value = "qrcode/{qrInfo:.+}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] qrCode (@PathVariable("qrInfo")String qrInfo) {
            
            ByteArrayOutputStream in = _qrCodeService.getQRCodeBytesStream(qrInfo);
            return in.toByteArray();
    }
    
}

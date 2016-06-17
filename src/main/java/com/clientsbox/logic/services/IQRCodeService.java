/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * https://github.com/kenglxn/QRGen
 */

package com.clientsbox.logic.services;

import java.io.ByteArrayOutputStream;

public interface IQRCodeService {
    public byte[] getQRCodeBytesStream (String text);
}

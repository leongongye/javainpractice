/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 *
 * @author leon
 * @version $Id: AESUtils.java, v 0.1 2016年6月15日 下午11:26:43 leon Exp $
 */
public class AESUtils {
    private static final int BLOCK_SIZE = 32;

    public static String encryptB64(String key, String text) {
        try {
            SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] b = cipher.doFinal(pkcs5Pad(text).getBytes());
            Encoder e = Base64.getEncoder();
            return e.encodeToString(b);
        } catch (Exception e) {
            return null;
        }
    }

    public static String decryptB64(String key, String text) {
        try {
            SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            Decoder d = Base64.getDecoder();

            byte[] b = cipher.doFinal(d.decode(text.getBytes()));
            return pkcs5Unpad(new String(b));
        } catch (Exception e) {
            return null;
        }
    }

    public static String pkcs5Unpad(String s) {
        return StringUtils.substring(s, 0, s.length() - (int) s.charAt(s.length() - 1));
    }

    public static String pkcs5Pad(String s) {
        int p = (BLOCK_SIZE - s.length() % BLOCK_SIZE);
        char pChar = (char) p;
        String ret = s;
        for (int i = 0; i < p; i++) {
            ret = ret + pChar;
        }
        return ret;
    }
}

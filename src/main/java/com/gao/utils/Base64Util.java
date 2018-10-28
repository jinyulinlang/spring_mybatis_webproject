package com.gao.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {
    /**
     * 對鈅加密的數據進行base64編碼
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] encode(String data) throws UnsupportedEncodingException {
        return Base64.getEncoder().encode(data.getBytes("UTF-8"));

    }

    public static String decode(byte[] data) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(data);
        return new String(data, "UTF-8");
    }

}


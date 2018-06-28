package com.middol

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CommonUtil {
    private static final SALT = "middol"

    static isStrEmpty(String str){
        if(str == null || str == ""){
            return true
        }
        return false
    }

    static isArrEmpty(Object [] ids){
        if(ids == null || ids.size() == 0){
            return true
        }
        return false
    }

    static isNum(Integer num){
        if(num instanceof Integer){
            return true
        }
        return false
    }

    /**
     * 32位Md5不可逆加密
     */
    static String getMD5(String message){
        message += SALT
        try {
            MessageDigest md = MessageDigest.getInstance("MD5")
            byte[] input = message.getBytes()
            byte[] buff = md.digest(input)
            return bytesToHex(buff)
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("99")
        }
    }

    /**
     * 二进制转十六进制
     * @param bytes
     * @return
     */
    static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer()
        //把数组每一字节换成16进制连成md5字符串
        int digital
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i]
            if(digital < 0) {
                digital += 256
            }
            if(digital < 16){
                md5str.append("0")
            }
            md5str.append(Integer.toHexString(digital))
        }
        return md5str.toString()
    }
}

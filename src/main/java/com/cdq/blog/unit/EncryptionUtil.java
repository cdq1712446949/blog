package com.cdq.blog.unit;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 加密解密工具（过程过于简单，并不是多么安全）
 * @author cdq
 * created on 2019.08.19
 */
public class EncryptionUtil {

    /**
     * 加密过程
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String getEncryptionStr(String str){
        Base64.Encoder encoder=Base64.getEncoder();
        String result="";
        try {
            result=encoder.encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("加密过程中获取字节失败："+e.getMessage());
        }
        return result;
    }

    /**
     * 解密过程
     * @param str 需要解密的字符串
     * @return 解密后的字符串
     */
    public static String getDecryptStr(String str){
        byte[] asBytes = Base64.getDecoder().decode(str);
        String result = null;
        try {
            result = new String(asBytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("解密过程中获取字节失败："+e.getMessage());
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getEncryptionStr("root"));
        System.out.println(getEncryptionStr("980814"));
        System.out.println(getDecryptStr("cm9vdA=="));
        System.out.println(getDecryptStr("OTgwODE0"));
    }

}

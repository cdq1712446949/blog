package com.cdq.blog.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {

    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isEmail(String email){
        if (null==email || "".equals(email)){
            return false;
        }
        Pattern p = Pattern.compile(REGEX_EMAIL);
        Matcher m = p.matcher(email);
        if(m.matches()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String msg = "1dasd23424@qq。cmn";
        System.out.println(isEmail(msg));
    }

}

package com.cdq.blog.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {

    /**
     * * 运营商号段如下：
     * * 中国联通号码：130、131、132、145（无线上网卡）、155、156、185（iPhone5上市后开放）、186、176（4G号段）、
     * *               175（2015年9月10日正式启用，暂只对北京、上海和广东投放办理）
     * * 中国移动号码：134、135、136、137、138、139、147（无线上网卡）、150、151、152、157、158、159、182、183、187、188、178
     * * 中国电信号码：133、153、180、181、189、177、173、149 虚拟运营商：170、1718、1719
     * * 手机号前3位的数字包括：
     * * 1 :1
     * * 2 :3,4,5,7,8
     * * 3 :0,1,2,3,4,5,6,7,8,9
     * * 总结： 目前java手机号码正则表达式有：
     * * a :"^1[3|4|5|7|8][0-9]\\d{4,8}$"    一般验证情况下这个就可以了
     * * b :"^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$"
     * * Pattern和Matcher详解（字符串匹配和字节码）http://blog.csdn.net/u010700335/article/details/44616451
     */

    //手机号码正则表达式
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    public static boolean isPhoneNumber(String phoneNumber) {
        if (null == phoneNumber || "".equals(phoneNumber)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(phoneNumber);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

}

package com.cdq.blog.unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdNumberUtil {

    /**
     * 地址码
     * 　　（身份证前六位）表示编码对象常住户口所在县(市、旗、区)的行政区划代码。
     * <p>
     * 出生日期码
     * 　　（身份证第七位到第十四位）表示编码对象出生的年、月、日，其中年份用四位数字表示，年、月、日之间不用分隔符。
     * 例如：1981年05月11日就用19810511表示。
     * <p>
     * 顺序码
     * 　　（身份证第十五位到十七位）为同一地址码所标识的区域范围内，对同年、月、日出生的人员编定的顺序号。
     * 其中第十七位奇数分给男性，偶数分给女性。
     * <p>
     * 校验码
     * 　　（身份证最后一位）是根据前面十七位数字码，按照ISO 7064:1983.MOD 11-2校验码计算出来的检验码。
     * 作为尾号的校验码，是由号码编制单位按统一的公式计算出来的，如果某人的尾号是0-9，都不会出现X，但如果尾号是10，
     * 那么就得用X来代替，因为如果用10做尾号，那么此人的身份证就变成了19位，而19位的号码违反了国家标准，
     * 并且我国的计算机应用系统也不承认19位的身份证号码。Ⅹ是罗马数字的10，用X来代替10，可以保证公民的身份证符合国家标准。
     */
    public static final String REGEX_IDNUMBER = "\\d{15}(\\d{2}[0-9xX])?";

    /**
     * 根据身份证号码获取性别
     *
     * @param idNumber
     * @return
     */
    public static String getSex(String idNumber) {
        if (isIdNumber(idNumber)) {
            int sex = Integer.valueOf(idNumber.substring(16, 17));
            if (sex % 2 == 1) {
                return "男";
            } else {
                return "女";
            }
        } else {
            return "false";
        }
    }

    /**
     * 根据身份证号码获取出生日期
     *
     * @param idNumber
     * @return
     */
    public static String getDate(String idNumber) {
        if (isIdNumber(idNumber)) {
            String temp = idNumber.substring(6, 14);
            return temp.substring(0,4)+"年"+temp.substring(4,6)+"月"+temp.substring(6,8)+"日";
        } else {
            return "false";
        }
    }

    /**
     * 根据身份证号码获取出生日期
     *
     * @param idNumber
     * @return
     */
    public static String getAddress(String idNumber) {
        if (isIdNumber(idNumber)) {
            return idNumber.substring(0, 6);
        } else {
            return "false";
        }
    }

    /**
     * 验证参数是否是身份证号
     *
     * @param idNumber 被验证的身份证号
     * @return 结果
     */
    public static boolean isIdNumber(String idNumber) {
        if (null == idNumber || "".equals(idNumber)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_IDNUMBER);
        Matcher m = p.matcher(idNumber);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String idNumber = "371428199810303016";
        System.out.println("行政编码：" + getAddress(idNumber));
        System.out.println("出生日期：" + getDate(idNumber));
        System.out.println("性别：" + getSex(idNumber));
    }

}

package com.cdq.blog.unit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date dateFormt(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");// 年-月-日
        String dateStr=sdf.format(date);
        return  sdf.parse(dateStr);
    }

    public static void main(String[] args){
        try {
            dateFormt(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

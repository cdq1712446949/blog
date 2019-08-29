package com.cdq.blog.unit;

import com.cdq.blog.model.Advertisement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ModelUtil {

    public static String modelToString(Object object) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuffer resultStr = new StringBuffer("{");
        //加载类
        Class<?> clazz = object.getClass();
        //获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        //遍历所有属性,并且根据属性名获取属性值
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            resultStr.append(field.getName() + ":");
            Method method = clazz.getDeclaredMethod("get" + firstCodeUpperCase(field.getName()));
            if (method.getReturnType() == Byte.class) {
                resultStr.append((byte) method.invoke(object));
                if (i != fields.length - 1){
                    resultStr.append(",");
                }
            } else {
                resultStr.append(method.invoke(object) );
                if (i != fields.length - 1){
                    resultStr.append(",");
                }
            }
        }
        resultStr.append("}");
        return resultStr.toString();
    }

    public static String firstCodeUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementStatus((byte) 1);
        advertisement.setAdvertisementCreateTime(new Date());
        advertisement.setAdvertisementName("ceshi");
        System.out.println(modelToString(advertisement));
    }

}

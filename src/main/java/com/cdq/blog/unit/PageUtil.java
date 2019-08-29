package com.cdq.blog.unit;

public class PageUtil {

    /**
     * 页码数转换为行数
     */
    public static int pageToRowIndex(int page,int pageSize){
        if (page==1){
            return 0;
        }else if (page>1){
            return (page-1)*pageSize;
        }
        return 0;
    }

}

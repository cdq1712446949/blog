package com.cdq.blog.dto;

import java.io.InputStream;

/**
 * @author cdq
 * created on 2019/06/25
 * 简化代码,类似于过度类
 */
public class ImageHolder {

    //文件名
    private String imageName;
    //输入流
    private InputStream inputStream;

    public ImageHolder(String imageName,InputStream inputStream){
        this.imageName=imageName;
        this.inputStream=inputStream;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}

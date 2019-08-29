package com.cdq.blog.model;

import java.util.Date;

public class PhotoType {
    private Byte photoTypeId;

    private String photoTypeDesc;

    private Date photoTypeCreateTime;

    private String photoTypeName;

    private Byte photoTypeStatus;

    public Byte getPhotoTypeId() {
        return photoTypeId;
    }

    public void setPhotoTypeId(Byte photoTypeId) {
        this.photoTypeId = photoTypeId;
    }

    public String getPhotoTypeDesc() {
        return photoTypeDesc;
    }

    public void setPhotoTypeDesc(String photoTypeDesc) {
        this.photoTypeDesc = photoTypeDesc == null ? null : photoTypeDesc.trim();
    }

    public Date getPhotoTypeCreateTime() {
        return photoTypeCreateTime;
    }

    public void setPhotoTypeCreateTime(Date photoTypeCreateTime) {
        this.photoTypeCreateTime = photoTypeCreateTime;
    }

    public String getPhotoTypeName() {
        return photoTypeName;
    }

    public void setPhotoTypeName(String photoTypeName) {
        this.photoTypeName = photoTypeName == null ? null : photoTypeName.trim();
    }

    public Byte getPhotoTypeStatus() {
        return photoTypeStatus;
    }

    public void setPhotoTypeStatus(Byte photoTypeStatus) {
        this.photoTypeStatus = photoTypeStatus;
    }
}
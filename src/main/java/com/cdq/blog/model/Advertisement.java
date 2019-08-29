package com.cdq.blog.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告类
 * mybatis generator自动创建
 */
public class Advertisement implements Serializable {
    //主键
    private Short advertisementId;
    //广告链接
    private String advertisementHref;
    //广告图片
    private String advertisementPhoto;
    //广告状态
    private Byte advertisementStatus;
    //广告备注
    private String advertisementName;
    //创建时间
    private Date advertisementCreateTime;
    //最后修改时间
    private Date advertisementLastEditTime;

    public Date getAdvertisementCreateTime() {
        return advertisementCreateTime;
    }

    public void setAdvertisementCreateTime(Date advertisementCreateTime) {
        this.advertisementCreateTime = advertisementCreateTime;
    }

    public Date getAdvertisementLastEditTime() {
        return advertisementLastEditTime;
    }

    public void setAdvertisementLastEditTime(Date advertisementLastEditTime) {
        this.advertisementLastEditTime = advertisementLastEditTime;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    public Short getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Short advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementHref() {
        return advertisementHref;
    }

    public void setAdvertisementHref(String advertisementHref) {
        this.advertisementHref = advertisementHref == null ? null : advertisementHref.trim();
    }

    public String getAdvertisementPhoto() {
        return advertisementPhoto;
    }

    public void setAdvertisementPhoto(String advertisementPhoto) {
        this.advertisementPhoto = advertisementPhoto == null ? null : advertisementPhoto.trim();
    }

    public Byte getAdvertisementStatus() {
        return advertisementStatus;
    }

    public void setAdvertisementStatus(Byte advertisementStatus) {
        this.advertisementStatus = advertisementStatus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
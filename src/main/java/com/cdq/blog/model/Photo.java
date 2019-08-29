package com.cdq.blog.model;

import java.util.Date;

public class Photo {
    private Integer photoId;

    private Byte photoTypeId;

    private Integer articleId;

    private Integer userReportId;

    private String photoName;

    private String photoAddr;

    private String photoDiscription;

    private Date photoCreateTime;

    private Byte photoStatus;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Byte getPhotoTypeId() {
        return photoTypeId;
    }

    public void setPhotoTypeId(Byte photoTypeId) {
        this.photoTypeId = photoTypeId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserReportId() {
        return userReportId;
    }

    public void setUserReportId(Integer userReportId) {
        this.userReportId = userReportId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoAddr() {
        return photoAddr;
    }

    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr == null ? null : photoAddr.trim();
    }

    public String getPhotoDiscription() {
        return photoDiscription;
    }

    public void setPhotoDiscription(String photoDiscription) {
        this.photoDiscription = photoDiscription == null ? null : photoDiscription.trim();
    }

    public Date getPhotoCreateTime() {
        return photoCreateTime;
    }

    public void setPhotoCreateTime(Date photoCreateTime) {
        this.photoCreateTime = photoCreateTime;
    }

    public Byte getPhotoStatus() {
        return photoStatus;
    }

    public void setPhotoStatus(Byte photoStatus) {
        this.photoStatus = photoStatus;
    }
}
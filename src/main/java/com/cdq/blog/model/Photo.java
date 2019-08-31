package com.cdq.blog.model;

import java.util.Date;

public class Photo {
    private Integer photoId;

    private PhotoType photoTypeId;

    private Article article;

    private UserReport userReport;

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

    public PhotoType getPhotoTypeId() {
        return photoTypeId;
    }

    public void setPhotoTypeId(PhotoType photoTypeId) {
        this.photoTypeId = photoTypeId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public UserReport getUserReport() {
        return userReport;
    }

    public void setUserReport(UserReport userReport) {
        this.userReport = userReport;
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
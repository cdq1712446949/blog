package com.cdq.blog.model;

import java.util.Date;

public class UserCollection {

    public static final int BAN_STATUS=-1;
    public static final int NORMAL_STATUS=0;

    private Integer collectionId;
    //用户所关注的用户
    private User user;
    //用户所关注的文章
    private Article article;
    private Byte collectionStatus;
    private Date collectionCreateTime;

    public Byte getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(Byte collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getCollectionCreateTime() {
        return collectionCreateTime;
    }

    public void setCollectionCreateTime(Date collectionCreateTime) {
        this.collectionCreateTime = collectionCreateTime;
    }
}
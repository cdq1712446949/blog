package com.cdq.blog.model;

import java.util.Date;

public class ThumbsUp {

    private int thumbsUpId;
    //点赞用户
    private User user;
    //被点赞的文章
    private Article article;
    private Date upCreateTime;
    private Byte upStatus;

    public Byte getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(Byte upStatus) {
        this.upStatus = upStatus;
    }

    public int getThumbsUpId() {
        return thumbsUpId;
    }

    public void setThumbsUpId(int thumbsUpId) {
        this.thumbsUpId = thumbsUpId;
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

    public Date getUpCreateTime() {
        return upCreateTime;
    }

    public void setUpCreateTime(Date upCreateTime) {
        this.upCreateTime = upCreateTime;
    }
}

package com.cdq.blog.model;

import java.util.Date;

public class UserComment {
    private Integer userCommentId;
    //评论所属文章
    private Article article;
    //评论所属评论
    private UserComment userComment;
    //发表评论的用户
    private User fromUser;
    //被回复用户
    private User toUser;

    private Byte userCommentStatus;

    private Date userCommentCreateTime;

    private String userCommentContent;

    public Integer getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(Integer userCommentId) {
        this.userCommentId = userCommentId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public UserComment getUserComment() {
        return userComment;
    }

    public void setUserComment(UserComment userComment) {
        this.userComment = userComment;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public Byte getUserCommentStatus() {
        return userCommentStatus;
    }

    public void setUserCommentStatus(Byte userCommentStatus) {
        this.userCommentStatus = userCommentStatus;
    }

    public Date getUserCommentCreateTime() {
        return userCommentCreateTime;
    }

    public void setUserCommentCreateTime(Date userCommentCreateTime) {
        this.userCommentCreateTime = userCommentCreateTime;
    }

    public String getUserCommentContent() {
        return userCommentContent;
    }

    public void setUserCommentContent(String userCommentContent) {
        this.userCommentContent = userCommentContent == null ? null : userCommentContent.trim();
    }
}
package com.cdq.blog.model;

import java.util.Date;

public class UserComment {
    private Integer userCommentId;

    private Integer articleId;

    private Integer commentId;

    private Integer fromUserId;

    private Integer toUserId;

    private Byte userCommentStatus;

    private Date userCommentCreateTime;

    private String userCommentContent;

    public Integer getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(Integer userCommentId) {
        this.userCommentId = userCommentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
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
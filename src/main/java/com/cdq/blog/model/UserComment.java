package com.cdq.blog.model;

import java.util.Date;
import java.util.List;

public class UserComment {

    public static final int  BAN_STATUS=-1;
    public static final int NORMAL_STATUS=0;

    private Integer userCommentId;
    //评论所属文章
    private Article article;
    //评论所属评论
    private UserComment userComment;
    //发表评论的用户
    private User fromUser;
    //被回复用户
    private User toUser;
    //该评论下的回复评论
    private List<UserComment> userCommentList;

    private Byte userCommentStatus;

    private Date userCommentCreateTime;

    private String userCommentContent;

    public List<UserComment> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserComment> userCommentList) {
        this.userCommentList = userCommentList;
    }

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
package com.cdq.blog.model;

public class UserInfo {

    private int userId;
    private int blogNum;
    private int funsNum;
    private int userLookNum;
    private int commentNum;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserLookNum() {
        return userLookNum;
    }

    public void setUserLookNum(int userLookNum) {
        this.userLookNum = userLookNum;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public int getFunsNum() {
        return funsNum;
    }

    public void setFunsNum(int funsNum) {
        this.funsNum = funsNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}

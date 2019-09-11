package com.cdq.blog.model;

import java.util.Date;

public class User {

    public final static int SUPER_ADMIN = 0;//超级管理员
    public final static int ADMIN = 1;//普通管理员
    public final static int USER = 2;//用户

    private Integer userId;

    private String userName;

    private String passWord;

    private String nickName;

    private String userSex;

    private Boolean userRole;

    private Integer userExprience;

    private Date userBirthday;

    private String userEmail;

    private String userHeadPhoto;

    private Byte userStatus;

    private Date userCreateTime;

    private Date userLaseEditTime;

    private Date userLastLoginTime;

    private String userLaseLoginIp;

    //用户简介
    private String userDesc;
    //用户手机号
    private String userPhone;
    //用户博客数量
    private int blogNum;
    //用户粉丝数量
    private int funsNum;
    //用户被浏览数量
    private int lookNum;
    //用户文章评论数量
    private int commentNum;

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

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Boolean getUserRole() {
        return userRole;
    }

    public void setUserRole(Boolean userRole) {
        this.userRole = userRole;
    }

    public Integer getUserExprience() {
        return userExprience;
    }

    public void setUserExprience(Integer userExprience) {
        this.userExprience = userExprience;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserHeadPhoto() {
        return userHeadPhoto;
    }

    public void setUserHeadPhoto(String userHeadPhoto) {
        this.userHeadPhoto = userHeadPhoto == null ? null : userHeadPhoto.trim();
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserLaseEditTime() {
        return userLaseEditTime;
    }

    public void setUserLaseEditTime(Date userLaseEditTime) {
        this.userLaseEditTime = userLaseEditTime;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public String getUserLaseLoginIp() {
        return userLaseLoginIp;
    }

    public void setUserLaseLoginIp(String userLaseLoginIp) {
        this.userLaseLoginIp = userLaseLoginIp == null ? null : userLaseLoginIp.trim();
    }
}
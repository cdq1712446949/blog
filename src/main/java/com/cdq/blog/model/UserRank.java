package com.cdq.blog.model;

import java.util.Date;

public class UserRank {
    private Byte userRankId;

    private UserLevel userLevel;

    private Date userRankCreateTime;

    private Date userRankLastEditTime;

    private String userRankDiscription;

    public Byte getUserRankId() {
        return userRankId;
    }

    public void setUserRankId(Byte userRankId) {
        this.userRankId = userRankId;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public Date getUserRankCreateTime() {
        return userRankCreateTime;
    }

    public void setUserRankCreateTime(Date userRankCreateTime) {
        this.userRankCreateTime = userRankCreateTime;
    }

    public Date getUserRankLastEditTime() {
        return userRankLastEditTime;
    }

    public void setUserRankLastEditTime(Date userRankLastEditTime) {
        this.userRankLastEditTime = userRankLastEditTime;
    }

    public String getUserRankDiscription() {
        return userRankDiscription;
    }

    public void setUserRankDiscription(String userRankDiscription) {
        this.userRankDiscription = userRankDiscription == null ? null : userRankDiscription.trim();
    }
}
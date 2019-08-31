package com.cdq.blog.model;

import java.util.Date;

public class UserReport {
    private Integer userReportId;
    //举报人
    private User reportUser;
    //被举报人
    private User reprotedUser;
    //被举报文章
    private Article article;
    //被举报评论
    private UserComment userComment;
    //举报原因
    private ReportReason reportReason;
    //举报原因描述
    private String userReportContent;

    private Byte userReportStatus;

    private Date userReportCreateTime;

    private Date userReportHandleTime;

    public Integer getUserReportId() {
        return userReportId;
    }

    public void setUserReportId(Integer userReportId) {
        this.userReportId = userReportId;
    }

    public User getReportUser() {
        return reportUser;
    }

    public void setReportUser(User reportUser) {
        this.reportUser = reportUser;
    }

    public User getReprotedUser() {
        return reprotedUser;
    }

    public void setReprotedUser(User reprotedUser) {
        this.reprotedUser = reprotedUser;
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

    public ReportReason getReportReason() {
        return reportReason;
    }

    public void setReportReason(ReportReason reportReason) {
        this.reportReason = reportReason;
    }

    public String getUserReportContent() {
        return userReportContent;
    }

    public void setUserReportContent(String userReportContent) {
        this.userReportContent = userReportContent == null ? null : userReportContent.trim();
    }

    public Byte getUserReportStatus() {
        return userReportStatus;
    }

    public void setUserReportStatus(Byte userReportStatus) {
        this.userReportStatus = userReportStatus;
    }

    public Date getUserReportCreateTime() {
        return userReportCreateTime;
    }

    public void setUserReportCreateTime(Date userReportCreateTime) {
        this.userReportCreateTime = userReportCreateTime;
    }

    public Date getUserReportHandleTime() {
        return userReportHandleTime;
    }

    public void setUserReportHandleTime(Date userReportHandleTime) {
        this.userReportHandleTime = userReportHandleTime;
    }
}
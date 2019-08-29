package com.cdq.blog.model;

import java.util.Date;

public class UserReport {
    private Integer userReportId;

    private Integer reportUserId;

    private Integer reprotedUserId;

    private Integer articleId;

    private Integer userCommentId;

    private Byte reportReasonId;

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

    public Integer getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Integer reportUserId) {
        this.reportUserId = reportUserId;
    }

    public Integer getReprotedUserId() {
        return reprotedUserId;
    }

    public void setReprotedUserId(Integer reprotedUserId) {
        this.reprotedUserId = reprotedUserId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(Integer userCommentId) {
        this.userCommentId = userCommentId;
    }

    public Byte getReportReasonId() {
        return reportReasonId;
    }

    public void setReportReasonId(Byte reportReasonId) {
        this.reportReasonId = reportReasonId;
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
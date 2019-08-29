package com.cdq.blog.model;

import java.util.Date;

public class Notice {
    private Short noticeId;

    private String noticeContent;

    private Date noticeCreateTime;

    private Date noticeLastEditTime;

    private Byte noticeStatus;

    public Short getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Short noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public Date getNoticeLastEditTime() {
        return noticeLastEditTime;
    }

    public void setNoticeLastEditTime(Date noticeLastEditTime) {
        this.noticeLastEditTime = noticeLastEditTime;
    }

    public Byte getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Byte noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}
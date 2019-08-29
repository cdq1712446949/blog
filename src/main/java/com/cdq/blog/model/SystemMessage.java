package com.cdq.blog.model;

import java.util.Date;

public class SystemMessage {
    private Integer systemMessageId;

    private Integer toUserId;

    private String messageContent;

    private Date messageCreateTime;

    private Byte isSee;

    public Integer getSystemMessageId() {
        return systemMessageId;
    }

    public void setSystemMessageId(Integer systemMessageId) {
        this.systemMessageId = systemMessageId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public Byte getIsSee() {
        return isSee;
    }

    public void setIsSee(Byte isSee) {
        this.isSee = isSee;
    }
}
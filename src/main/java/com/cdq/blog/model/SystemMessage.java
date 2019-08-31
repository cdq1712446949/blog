package com.cdq.blog.model;

import java.util.Date;

public class SystemMessage {
    private Integer systemMessageId;

    private User toUser;

    private String messageContent;

    private Date messageCreateTime;

    private Byte isSee;

    public Integer getSystemMessageId() {
        return systemMessageId;
    }

    public void setSystemMessageId(Integer systemMessageId) {
        this.systemMessageId = systemMessageId;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
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
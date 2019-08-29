package com.cdq.blog.model;

import java.util.Date;

public class SecretMessage {
    private Integer secretMessageId;

    private Integer fromUserId;

    private Integer toUserId;

    private Byte isSee;

    private Date messageCreateTime;

    private String messageContent;

    public Integer getSecretMessageId() {
        return secretMessageId;
    }

    public void setSecretMessageId(Integer secretMessageId) {
        this.secretMessageId = secretMessageId;
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

    public Byte getIsSee() {
        return isSee;
    }

    public void setIsSee(Byte isSee) {
        this.isSee = isSee;
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }
}
package com.cdq.blog.model;

import java.util.Date;

public class SecretMessage {
    private Integer secretMessageId;

    private User fromUser;

    private User toUser;

    private Byte isSee;

    private Date messageCreateTime;

    private String messageContent;

    public Integer getSecretMessageId() {
        return secretMessageId;
    }

    public void setSecretMessageId(Integer secretMessageId) {
        this.secretMessageId = secretMessageId;
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
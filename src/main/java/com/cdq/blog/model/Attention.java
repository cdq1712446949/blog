package com.cdq.blog.model;

import java.util.Date;

public class Attention {
    private Integer attentionId;

    private User attentionUser;

    private User attentedUser;

    private Date attentionCreateTime;

    private short attentionStatus;

    public short getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(short attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public User getAttentionUser() {
        return attentionUser;
    }

    public void setAttentionUser(User attentionUser) {
        this.attentionUser = attentionUser;
    }

    public User getAttentedUser() {
        return attentedUser;
    }

    public void setAttentedUser(User attentedUser) {
        this.attentedUser = attentedUser;
    }

    public Date getAttentionCreateTime() {
        return attentionCreateTime;
    }

    public void setAttentionCreateTime(Date attentionCreateTime) {
        this.attentionCreateTime = attentionCreateTime;
    }
}
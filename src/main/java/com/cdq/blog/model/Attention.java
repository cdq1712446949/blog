package com.cdq.blog.model;

import java.util.Date;

public class Attention {
    private Integer attentionId;

    private Integer attentionUserId;

    private Integer attentedUserId;

    private Date attentionCreateTime;

    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Integer getAttentionUserId() {
        return attentionUserId;
    }

    public void setAttentionUserId(Integer attentionUserId) {
        this.attentionUserId = attentionUserId;
    }

    public Integer getAttentedUserId() {
        return attentedUserId;
    }

    public void setAttentedUserId(Integer attentedUserId) {
        this.attentedUserId = attentedUserId;
    }

    public Date getAttentionCreateTime() {
        return attentionCreateTime;
    }

    public void setAttentionCreateTime(Date attentionCreateTime) {
        this.attentionCreateTime = attentionCreateTime;
    }
}
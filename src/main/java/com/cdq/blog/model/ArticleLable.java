package com.cdq.blog.model;

import java.util.Date;

public class ArticleLable {
    private Integer articleLableId;

    private Integer articleId;

    private String articleLableName;

    private Date articleLableCreateTime;

    private Byte articleLableStatus;

    public Byte getArticleLableStatus() {
        return articleLableStatus;
    }

    public void setArticleLableStatus(Byte articleLableStatus) {
        this.articleLableStatus = articleLableStatus;
    }

    public Integer getArticleLableId() {
        return articleLableId;
    }

    public void setArticleLableId(Integer articleLableId) {
        this.articleLableId = articleLableId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleLableName() {
        return articleLableName;
    }

    public void setArticleLableName(String articleLableName) {
        this.articleLableName = articleLableName == null ? null : articleLableName.trim();
    }

    public Date getArticleLableCreateTime() {
        return articleLableCreateTime;
    }

    public void setArticleLableCreateTime(Date articleLableCreateTime) {
        this.articleLableCreateTime = articleLableCreateTime;
    }
}
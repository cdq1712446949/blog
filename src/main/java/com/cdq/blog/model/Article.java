package com.cdq.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article {
    private Integer articleId;

    private Integer userId;

    private Short goodNum;

    private Short lookNum;

    private Short articleTypeId;

    private String articleTitle;

    private String articleDiscription;

    private String articleKeyWord;

    private Byte articleStatus;

    private Date articleCreateTime;

    private Date articleLastEditTime;

    private String articleContent;
    //文章标签
    private List<ArticleLable> articleLableList=new ArrayList<>();
    //文章作者
    private User user;
    //文章类型
    private ArticleType articleType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public List<ArticleLable> getArticleLableList() {
        return articleLableList;
    }

    public void setArticleLableList(List<ArticleLable> articleList) {
        this.articleLableList = articleList;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Short getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Short goodNum) {
        this.goodNum = goodNum;
    }

    public Short getLookNum() {
        return lookNum;
    }

    public void setLookNum(Short lookNum) {
        this.lookNum = lookNum;
    }

    public Short getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Short articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleDiscription() {
        return articleDiscription;
    }

    public void setArticleDiscription(String articleDiscription) {
        this.articleDiscription = articleDiscription == null ? null : articleDiscription.trim();
    }

    public String getArticleKeyWord() {
        return articleKeyWord;
    }

    public void setArticleKeyWord(String articleKeyWord) {
        this.articleKeyWord = articleKeyWord == null ? null : articleKeyWord.trim();
    }

    public Byte getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Byte articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Date getArticleLastEditTime() {
        return articleLastEditTime;
    }

    public void setArticleLastEditTime(Date articleLastEditTime) {
        this.articleLastEditTime = articleLastEditTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}
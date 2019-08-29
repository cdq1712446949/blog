package com.cdq.blog.dto;

import com.cdq.blog.model.Article;
import com.cdq.blog.state.ArticleStateEnum;
import com.cdq.blog.state.BaseStateEnum;

import java.io.Serializable;
import java.util.List;

/**
 * @author CDQ
 * created  on 2019/6.25
 * service调用对象，用于对controller返回数据
 */
public class ArticleExecution {

    //状态值
    private int state;
    //状态信息
    private String stateInfo;
    //操作对象数量
    private int count;
    //单个操作对象
    private Article article;
    //操作对象列表
    private List<Article> articleList;

    //失败时使用的构造器
    public ArticleExecution(BaseStateEnum baseStateEnum) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
    }

    //操作成功时使用的构造器
    public ArticleExecution(BaseStateEnum baseStateEnum,Article article) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
        this.article = article;
    }

    //操作成功时使用的构造器
    public ArticleExecution(BaseStateEnum baseStateEnum,List<Article> articles) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
        this.articleList = articles;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
        this.count = 1;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.count = articleList.size();
        this.articleList = articleList;
    }
}

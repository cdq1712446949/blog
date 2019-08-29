package com.cdq.blog.dto;

import com.cdq.blog.model.ArticleType;
import com.cdq.blog.state.ArticleTypeStateEnum;

import java.io.Serializable;
import java.util.List;

public class ArticleTypeExecution implements Serializable {
    //状态值
    private int state;
    //状态信息
    private String stateInfo;
    //操作参数，一个或者多个
    private ArticleType articleType;
    private List<ArticleType> articleTypeList;
    //如果是多个，count表示参数的数量
    private int count;

    /**
     * 根据操作参数的不同调用不同的构造器
     * @param articleStateEnum
     */
    public ArticleTypeExecution(ArticleTypeStateEnum articleStateEnum){
        this.state=articleStateEnum.getState();
        this.stateInfo=articleStateEnum.getStateInfo();
    }

    public ArticleTypeExecution(ArticleTypeStateEnum articleStateEnum,ArticleType articleType){
        this.state=articleStateEnum.getState();
        this.stateInfo=articleStateEnum.getStateInfo();
        this.articleType=articleType;
    }

    public ArticleTypeExecution(ArticleTypeStateEnum articleStateEnum, List<ArticleType> articleTypeList){
        this.state=articleStateEnum.getState();
        this.stateInfo=articleStateEnum.getStateInfo();
        this.articleTypeList=articleTypeList;
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

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public List<ArticleType> getArticleTypeList() {
        return articleTypeList;
    }

    public void setArticleTypeList(List<ArticleType> articleTypeList) {
        this.articleTypeList = articleTypeList;
    }

    public int getCount() {
        return this.articleTypeList.size();
    }

}

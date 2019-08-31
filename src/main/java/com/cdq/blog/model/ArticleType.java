package com.cdq.blog.model;

import com.cdq.blog.unit.ModelUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class ArticleType implements Serializable {
    private Short articleTypeId;

    private String articleTypeName;

    private Byte priority;

    private Integer clickNum;

    private Date articleTypeCreateTime;

    private Date articleTypeLastEditTime;

    //父类文章类型
    private ArticleType parentArticleType;

    public ArticleType getParentArticleType() {
        return parentArticleType;
    }

    public void setParentArticleType(ArticleType parentArticleType) {
        this.parentArticleType = parentArticleType;
    }

    public Short getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Short articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName == null ? null : articleTypeName.trim();
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Date getArticleTypeCreateTime() {
        return articleTypeCreateTime;
    }

    public void setArticleTypeCreateTime(Date articleTypeCreateTime) {
        this.articleTypeCreateTime = articleTypeCreateTime;
    }

    public Date getArticleTypeLastEditTime() {
        return articleTypeLastEditTime;
    }

    public void setArticleTypeLastEditTime(Date articleTypeLastEditTime) {
        this.articleTypeLastEditTime = articleTypeLastEditTime;
    }

    @Override
    public String toString() {
        try {
            return ModelUtil.modelToString(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.toString();
    }
}
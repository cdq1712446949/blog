package com.cdq.blog.model;

import com.cdq.blog.unit.ModelUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class UserLevel implements Serializable {
    private Byte userLevelId;

    private Integer userLevelExprience;

    private String userLevelName;

    public Byte getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Byte userLevelId) {
        this.userLevelId = userLevelId;
    }

    public Integer getUserLevelExprience() {
        return userLevelExprience;
    }

    public void setUserLevelExprience(Integer userLevelExprience) {
        this.userLevelExprience = userLevelExprience;
    }

    public String getUserLevelName() {
        return userLevelName;
    }

    public void setUserLevelName(String userLevelName) {
        this.userLevelName = userLevelName == null ? null : userLevelName.trim();
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
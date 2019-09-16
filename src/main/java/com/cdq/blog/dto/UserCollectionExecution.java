package com.cdq.blog.dto;

import com.cdq.blog.model.UserCollection;
import com.cdq.blog.state.BaseStateEnum;

import java.util.List;

public class UserCollectionExecution {


    //状态值
    private int state;
    //状态信息
    private String stateInfo;
    //操作对象数量
    private int count;
    //单个操作对象
    private UserCollection userCollection;
    //操作对象列表
    private List<UserCollection> userCollectionList;

    //失败时使用的构造器
    public UserCollectionExecution(BaseStateEnum baseStateEnum) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
    }

    //操作成功时使用的构造器
    public UserCollectionExecution(BaseStateEnum baseStateEnum,UserCollection userCollection) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
        this.userCollection = userCollection;
    }

    //操作成功时使用的构造器
    public UserCollectionExecution(BaseStateEnum baseStateEnum,List<UserCollection> userCollectionList) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
        this.userCollectionList = userCollectionList;
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
        return this.userCollectionList.size();
    }

    public UserCollection getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(UserCollection userCollection) {
        this.userCollection = userCollection;
    }

    public List<UserCollection> getUserCollectionList() {
        return userCollectionList;
    }

    public void setUserCollectionList(List<UserCollection> userCollectionList) {
        this.userCollectionList = userCollectionList;
    }
}

package com.cdq.blog.dto;

import com.cdq.blog.model.ThumbsCollection;
import com.cdq.blog.model.User;
import com.cdq.blog.model.UserInfo;
import com.cdq.blog.state.UserStateEnum;

import java.util.List;

public class UserExecution {

    private int state;
    private String stateInfo;
    private User user;
    private List<User> userList;
    private int count;
    private UserInfo userInfo;
    private ThumbsCollection thumbsCollection;



    public UserExecution(UserStateEnum userStateEnum,UserInfo userInfo){
        this.state=userStateEnum.getState();
        this.stateInfo=userStateEnum.getStateInfo();
        this.userInfo=userInfo;
    }

    public UserExecution(UserStateEnum userStateEnum,ThumbsCollection thumbsCollection){
        this.state=userStateEnum.getState();
        this.stateInfo=userStateEnum.getStateInfo();
        this.thumbsCollection=thumbsCollection;
    }

    public UserExecution(UserStateEnum userStateEnum){
        this.state=userStateEnum.getState();
        this.stateInfo=userStateEnum.getStateInfo();
    }

    public UserExecution(UserStateEnum userStateEnum,User user){
        this.state=userStateEnum.getState();
        this.stateInfo=userStateEnum.getStateInfo();
        this.user=user;
    }

    public UserExecution(UserStateEnum userStateEnum,List<User> userList){
        this.state=userStateEnum.getState();
        this.stateInfo=userStateEnum.getStateInfo();
        this.userList=userList;
    }

    public ThumbsCollection getThumbsCollection() {
        return thumbsCollection;
    }

    public void setThumbsCollection(ThumbsCollection thumbsCollection) {
        this.thumbsCollection = thumbsCollection;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getCount() {
        return this.userList.size();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}

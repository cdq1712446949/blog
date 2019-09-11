package com.cdq.blog.dto;

import com.cdq.blog.model.Article;
import com.cdq.blog.model.UserComment;
import com.cdq.blog.state.BaseStateEnum;
import com.cdq.blog.state.UserCommentStateEnum;

import java.util.List;

public class UserCommentExecution {

    //状态值
    private int state;
    //状态信息
    private String stateInfo;
    //操作对象数量
    private int count;
    //单个操作对象
    private UserComment userComment;
    //操作对象列表
    private List<UserComment> userCommentList;

    //失败时使用的构造器
    public UserCommentExecution(UserCommentStateEnum userCommentStateEnum) {
        this.state = userCommentStateEnum.getState();
        this.stateInfo = userCommentStateEnum.getStateInfo();
    }

    //操作成功时使用的构造器
    public UserCommentExecution(UserCommentStateEnum userCommentStateEnum,UserComment userComment) {
        this.state = userCommentStateEnum.getState();
        this.stateInfo = userCommentStateEnum.getStateInfo();
        this.userComment = userComment;
    }

    //操作成功时使用的构造器
    public UserCommentExecution(UserCommentStateEnum userCommentStateEnum,List<UserComment> userCommentList) {
        this.state = userCommentStateEnum.getState();
        this.stateInfo = userCommentStateEnum.getStateInfo();
        this.userCommentList = userCommentList;
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
        return this.userCommentList.size();
    }

    public UserComment getUserComment() {
        return userComment;
    }

    public void setUserComment(UserComment userComment) {
        this.userComment = userComment;
    }

    public List<UserComment> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserComment> userCommentList) {
        this.userCommentList = userCommentList;
    }
}

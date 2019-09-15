package com.cdq.blog.dto;

import com.cdq.blog.model.ThumbsUp;
import com.cdq.blog.state.BaseStateEnum;

import java.util.List;

public class ThumbsUpExecution {

    //状态值
    private int state;
    //状态信息
    private String stateInfo;
    //操作对象数量
    private int count;
    //单个操作对象
    private ThumbsUp thumbsUp;
    //操作对象列表
    private List<ThumbsUp> thumbsUpList;

    //失败时使用的构造器
    public ThumbsUpExecution(BaseStateEnum baseStateEnum) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
    }

    //操作成功时使用的构造器
    public ThumbsUpExecution(BaseStateEnum baseStateEnum,ThumbsUp thumbsUp) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
        this.thumbsUp = thumbsUp;
    }

    //操作成功时使用的构造器
    public ThumbsUpExecution(BaseStateEnum baseStateEnum,List<ThumbsUp> thumbsUpList) {
        this.state = baseStateEnum.getState();
        this.stateInfo = baseStateEnum.getStateInfo();
        this.thumbsUpList = thumbsUpList;
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
        return this.thumbsUpList.size();
    }

    public ThumbsUp getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(ThumbsUp thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public List<ThumbsUp> getThumbsUpList() {
        return thumbsUpList;
    }

    public void setThumbsUpList(List<ThumbsUp> thumbsUpList) {
        this.thumbsUpList = thumbsUpList;
    }
}

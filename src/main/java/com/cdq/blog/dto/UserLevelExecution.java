package com.cdq.blog.dto;

import com.cdq.blog.model.UserLevel;
import com.cdq.blog.state.UserLevelStateEnum;

import java.util.List;

public class UserLevelExecution {

    //状态值
    private int state;
    //状态信息
    private String stateInfo;
    //操作的对象列表
    private List<UserLevel> levelList;
    //对象数量
    private int count;

    //操作失败时的构造器
    public UserLevelExecution(UserLevelStateEnum userLevelStateEnum){
        this.state=userLevelStateEnum.getState();
        this.stateInfo=userLevelStateEnum.getStateInfo();
    }

    //操作成功时的构造器
    public UserLevelExecution(UserLevelStateEnum userLevelStateEnum,List<UserLevel> levels){
        this.state=userLevelStateEnum.getState();
        this.stateInfo=userLevelStateEnum.getStateInfo();
        this.levelList=levels;
        this.count=levels.size();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStatInfo() {
        return stateInfo;
    }

    public void setStatInfo(String statInfo) {
        this.stateInfo = statInfo;
    }

    public List<UserLevel> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<UserLevel> levelList) {
        this.levelList = levelList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

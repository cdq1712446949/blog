package com.cdq.blog.state;

public enum  NoticeStateEnum {

    SUCCESS(0,"操作成功"),INNER_ERROR(-1001,"系统错误"),EMPTY_CONTENT(-1002,"内容不能为空"),
    EMPTY_ID(-1003,"id不能为空");

    private int state;
    private String stateInfo;

    NoticeStateEnum(int state,String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}

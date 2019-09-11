package com.cdq.blog.state;

public enum UserCommentStateEnum {

    SUCCESS(0,"操作成功"),INNER_ERROR(-1001,"系统错误"),EMPTY_ARTICLEID(-1002,"文章id为空");

    private int state;
    private String stateInfo;

    UserCommentStateEnum(int state,String stateInfo){
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

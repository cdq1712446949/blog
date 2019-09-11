package com.cdq.blog.state;

public enum  BaseStateEnum {

    SUCCESS(0,"操作成功"),INNER_ERROR(-1001,"系统错误，请重试"),EMPTY_CONTENT(-1002,"内容不能为空"),
    EMPTY_ID(-1003,"id不能为空"),EMPTY_INFO(-1004,"一个或者多个属性值为空"),EMPTY_USER(-1005,"创建者id不能为空"),
    ILLEGAL_PARAMETER(-1006,"非法参数"),OBJECT_ISNULL(-1007,"查询对象不存在");

    private int state;
    private String stateInfo;

    BaseStateEnum(int state,String stateInfo){
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

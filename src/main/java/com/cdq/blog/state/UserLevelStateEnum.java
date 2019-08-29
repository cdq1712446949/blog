package com.cdq.blog.state;

public enum UserLevelStateEnum {
    SUCCCESS(0, "操作成功"), INNER_ERROR(-1, "系统错误"), EMPTY_ERROR(-1001, "内容为空"),EMPTY_ID(-1002,"id为空");

    private int state;
    private String stateInfo;

    UserLevelStateEnum(int state, String stateInfo) {
        this.stateInfo = stateInfo;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}

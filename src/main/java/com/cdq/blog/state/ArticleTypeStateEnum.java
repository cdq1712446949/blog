package com.cdq.blog.state;

public enum ArticleTypeStateEnum {

    SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "系统错误"),EMPTY_RESULT(-1,"查询结果为空"),EMPTY_ID(-1002,"id不能为空" )
    ,ILLEGAL_PARAMETER(-1003,"非法参数");

    private int state;
    private String stateInfo;

    ArticleTypeStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}

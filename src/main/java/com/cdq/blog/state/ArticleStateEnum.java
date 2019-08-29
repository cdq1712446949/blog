package com.cdq.blog.state;

public enum ArticleStateEnum {
    SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "内部系统错误")
    ,USER_EMPTY(-1002,"未找到文章作者"),ARTICLE_EMPTY(-1003,"请填写所有必填字段");

    private int state;
    private String stateInfo;

    ArticleStateEnum(int state, String stateInfo) {
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

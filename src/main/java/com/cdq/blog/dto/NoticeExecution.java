package com.cdq.blog.dto;

import com.cdq.blog.model.Notice;
import com.cdq.blog.state.NoticeStateEnum;

import java.util.List;

public class NoticeExecution {

    private int state;
    private String stateInfo;
    private Notice notice;
    private List<Notice> noticeList;
    private int count;

    public NoticeExecution(NoticeStateEnum noticeStateEnum){
        this.state=noticeStateEnum.getState();
        this.stateInfo=noticeStateEnum.getStateInfo();
    }

    public NoticeExecution(NoticeStateEnum noticeStateEnum,Notice notice){
        this.state=noticeStateEnum.getState();
        this.stateInfo=noticeStateEnum.getStateInfo();
        this.notice=notice;
    }

    public NoticeExecution(NoticeStateEnum noticeStateEnum,List<Notice> noticeList){
        this.state=noticeStateEnum.getState();
        this.stateInfo=noticeStateEnum.getStateInfo();
        this.noticeList=noticeList;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public Notice getNotice() {
        return notice;
    }

    public List<Notice> getNoticeList() {
        return noticeList;
    }

    public int getCount() {
        return noticeList.size();
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }
}

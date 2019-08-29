package com.cdq.blog.model;

import java.util.Date;

public class ReportReason {
    private Byte reportReasonId;

    private String reportReasonName;

    private Date reportReasonCreateTime;

    private Date reportReasonLastEditTime;

    public Byte getReportReasonId() {
        return reportReasonId;
    }

    public void setReportReasonId(Byte reportReasonId) {
        this.reportReasonId = reportReasonId;
    }

    public String getReportReasonName() {
        return reportReasonName;
    }

    public void setReportReasonName(String reportReasonName) {
        this.reportReasonName = reportReasonName == null ? null : reportReasonName.trim();
    }

    public Date getReportReasonCreateTime() {
        return reportReasonCreateTime;
    }

    public void setReportReasonCreateTime(Date reportReasonCreateTime) {
        this.reportReasonCreateTime = reportReasonCreateTime;
    }

    public Date getReportReasonLastEditTime() {
        return reportReasonLastEditTime;
    }

    public void setReportReasonLastEditTime(Date reportReasonLastEditTime) {
        this.reportReasonLastEditTime = reportReasonLastEditTime;
    }
}
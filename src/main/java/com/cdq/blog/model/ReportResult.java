package com.cdq.blog.model;

public class ReportResult {
    private Integer reportResultId;

    private Integer userReportId;

    private Byte resultReportStatus;

    private String remark;

    public Integer getReportResultId() {
        return reportResultId;
    }

    public void setReportResultId(Integer reportResultId) {
        this.reportResultId = reportResultId;
    }

    public Integer getUserReportId() {
        return userReportId;
    }

    public void setUserReportId(Integer userReportId) {
        this.userReportId = userReportId;
    }

    public Byte getResultReportStatus() {
        return resultReportStatus;
    }

    public void setResultReportStatus(Byte resultReportStatus) {
        this.resultReportStatus = resultReportStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
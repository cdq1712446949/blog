package com.cdq.blog.model;

public class ReportResult {
    private Integer reportResultId;

    private UserReport userReport;

    private Byte resultReportStatus;

    private String remark;

    public Integer getReportResultId() {
        return reportResultId;
    }

    public void setReportResultId(Integer reportResultId) {
        this.reportResultId = reportResultId;
    }

    public UserReport getUserReport() {
        return userReport;
    }

    public void setUserReport(UserReport userReport) {
        this.userReport = userReport;
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
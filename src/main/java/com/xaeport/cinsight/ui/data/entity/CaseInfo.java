package com.xaeport.cinsight.ui.data.entity;

/**
 * Created by xcp on 2017/5/25.
 */
public class CaseInfo {
    public String caseId;
    public String caseCode;
    public String caseName;
    public String caseOperator;
    public Long kickoffDate;
    public Long lastViewTime;
    public int mailAmount;
    public String remark;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseOperator() {
        return caseOperator;
    }

    public void setCaseOperator(String caseOperator) {
        this.caseOperator = caseOperator;
    }

    public Long getKickoffDate() {
        return kickoffDate;
    }

    public void setKickoffDate(Long kickoffDate) {
        this.kickoffDate = kickoffDate;
    }

    public Long getLastViewTime() {
        return lastViewTime;
    }

    public void setLastViewTime(Long lastViewTime) {
        this.lastViewTime = lastViewTime;
    }

    public int getMailAmount() {
        return mailAmount;
    }

    public void setMailAmount(int mailAmount) {
        this.mailAmount = mailAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

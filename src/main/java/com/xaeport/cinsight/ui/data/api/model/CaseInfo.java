package com.xaeport.cinsight.ui.data.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * CaseInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class CaseInfo {
    @JsonProperty("caseId")
    private String caseId = null;

    @JsonProperty("caseName")
    private String caseName = null;

    @JsonProperty("lastViewTime")
    private Long lastViewTime = null;

    @JsonProperty("caseOperator")
    private String caseOperator = null;

    @JsonProperty("kickoffDate")
    private Long kickoffDate = null;

    @JsonProperty("remark")
    private String remark = null;

    @JsonProperty("mailAmount")
    private Integer mailAmount = null;

    public CaseInfo caseId(String caseId) {
        this.caseId = caseId;
        return this;
    }

    /**
     * 案件编号
     *
     * @return caseId
     **/
    @ApiModelProperty(value = "案件编号")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public CaseInfo caseName(String caseName) {
        this.caseName = caseName;
        return this;
    }

    /**
     * 案件名称
     *
     * @return caseName
     **/
    @ApiModelProperty(value = "案件名称")
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public CaseInfo lastViewTime(Long lastViewTime) {
        this.lastViewTime = lastViewTime;
        return this;
    }

    /**
     * 最后查看时间
     *
     * @return lastViewTime
     **/
    @ApiModelProperty(value = "最后查看时间")
    public Long getLastViewTime() {
        return lastViewTime;
    }

    public void setLastViewTime(Long lastViewTime) {
        this.lastViewTime = lastViewTime;
    }

    public CaseInfo caseOperator(String caseOperator) {
        this.caseOperator = caseOperator;
        return this;
    }

    /**
     * 负责人
     *
     * @return caseOperator
     **/
    @ApiModelProperty(value = "负责人")
    public String getCaseOperator() {
        return caseOperator;
    }

    public void setCaseOperator(String caseOperator) {
        this.caseOperator = caseOperator;
    }

    public CaseInfo kickoffDate(Long kickoffDate) {
        this.kickoffDate = kickoffDate;
        return this;
    }

    /**
     * 立案日期
     *
     * @return kickoffDate
     **/
    @ApiModelProperty(value = "立案日期")
    public Long getKickoffDate() {
        return kickoffDate;
    }

    public void setKickoffDate(Long kickoffDate) {
        this.kickoffDate = kickoffDate;
    }

    public CaseInfo remark(String remark) {
        this.remark = remark;
        return this;
    }

    /**
     * 备注
     *
     * @return remark
     **/
    @ApiModelProperty(value = "备注")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CaseInfo mailAmount(Integer mailAmount) {
        this.mailAmount = mailAmount;
        return this;
    }

    /**
     * 邮件数目
     *
     * @return mailAmount
     **/
    @ApiModelProperty(value = "邮件数目")
    public Integer getMailAmount() {
        return mailAmount;
    }

    public void setMailAmount(Integer mailAmount) {
        this.mailAmount = mailAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CaseInfo _case = (CaseInfo) o;
        return Objects.equals(this.caseId, _case.caseId) &&
                Objects.equals(this.caseName, _case.caseName) &&
                Objects.equals(this.lastViewTime, _case.lastViewTime) &&
                Objects.equals(this.caseOperator, _case.caseOperator) &&
                Objects.equals(this.kickoffDate, _case.kickoffDate) &&
                Objects.equals(this.remark, _case.remark) &&
                Objects.equals(this.mailAmount, _case.mailAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId, caseName, lastViewTime, caseOperator, kickoffDate, remark, mailAmount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CaseInfo {\n");

        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    caseName: ").append(toIndentedString(caseName)).append("\n");
        sb.append("    lastViewTime: ").append(toIndentedString(lastViewTime)).append("\n");
        sb.append("    caseOperator: ").append(toIndentedString(caseOperator)).append("\n");
        sb.append("    kickoffDate: ").append(toIndentedString(kickoffDate)).append("\n");
        sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
        sb.append("    mailAmount: ").append(toIndentedString(mailAmount)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


/*
 * 案件分析引擎
 * 案件分析引擎
 *
 * OpenAPI spec version: 1.0.0
 * Contact: cinsight@xaeport.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.xaeport.cinsight.ui.engine.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * 案件信息
 */
@ApiModel(description = "案件信息")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-21T07:16:57.704Z")
public class CaseInfo {
    @SerializedName("caseId")
    private String caseId = null;

    @SerializedName("mailAmount")
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
    @ApiModelProperty(example = "null", value = "案件编号")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
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
    @ApiModelProperty(example = "null", value = "邮件数目")
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
        CaseInfo caseInfo = (CaseInfo) o;
        return Objects.equals(this.caseId, caseInfo.caseId) &&
                Objects.equals(this.mailAmount, caseInfo.mailAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId, mailAmount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CaseInfo {\n");

        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
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

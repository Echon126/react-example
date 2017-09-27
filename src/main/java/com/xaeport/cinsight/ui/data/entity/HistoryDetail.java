package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * HistoryDetail
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class HistoryDetail {
    @JsonProperty("historyId")
    private String historyId = null;

    @JsonProperty("historyName")
    private String historyName = null;

    @JsonProperty("historyPage")
    private String historyPage = null;

    @JsonProperty("detailId")
    private String detailId = null;

    @JsonProperty("createTime")
    private Long createTime = null;

    @JsonProperty("conditions")
    private List<Condition> conditions = new ArrayList<Condition>();

    public HistoryDetail historyId(String historyId) {
        this.historyId = historyId;
        return this;
    }

    /**
     * 操作记录id
     *
     * @return historyId
     **/
    @ApiModelProperty(value = "操作记录id")
    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public HistoryDetail historyName(String historyName) {
        this.historyName = historyName;
        return this;
    }

    /**
     * 操作记录名称
     *
     * @return historyName
     **/
    @ApiModelProperty(value = "操作记录名称")
    public String getHistoryName() {
        return historyName;
    }

    public void setHistoryName(String historyName) {
        this.historyName = historyName;
    }

    public HistoryDetail historyPage(String historyPage) {
        this.historyPage = historyPage;
        return this;
    }

    /**
     * 操作界面
     *
     * @return historyPage
     **/
    @ApiModelProperty(value = "操作界面")
    public String getHistoryPage() {
        return historyPage;
    }

    public void setHistoryPage(String historyPage) {
        this.historyPage = historyPage;
    }

    public HistoryDetail detailId(String detailId) {
        this.detailId = detailId;
        return this;
    }

    /**
     * 详情id
     *
     * @return detailId
     **/
    @ApiModelProperty(value = "详情id")
    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public HistoryDetail createTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 结果集创建时间
     *
     * @return createTime
     **/
    @ApiModelProperty(value = "结果集创建时间")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public HistoryDetail conditions(List<Condition> conditions) {
        this.conditions = conditions;
        return this;
    }

    public HistoryDetail addConditionsItem(Condition conditionsItem) {
        this.conditions.add(conditionsItem);
        return this;
    }

    /**
     * 检索条件
     *
     * @return conditions
     **/
    @ApiModelProperty(value = "检索条件")
    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HistoryDetail historyDetail = (HistoryDetail) o;
        return Objects.equals(this.historyId, historyDetail.historyId) &&
                Objects.equals(this.historyName, historyDetail.historyName) &&
                Objects.equals(this.historyPage, historyDetail.historyPage) &&
                Objects.equals(this.detailId, historyDetail.detailId) &&
                Objects.equals(this.createTime, historyDetail.createTime) &&
                Objects.equals(this.conditions, historyDetail.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyId, historyName, historyPage, detailId, createTime, conditions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HistoryDetail {\n");

        sb.append("    historyId: ").append(toIndentedString(historyId)).append("\n");
        sb.append("    historyName: ").append(toIndentedString(historyName)).append("\n");
        sb.append("    historyPage: ").append(toIndentedString(historyPage)).append("\n");
        sb.append("    detailId: ").append(toIndentedString(detailId)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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


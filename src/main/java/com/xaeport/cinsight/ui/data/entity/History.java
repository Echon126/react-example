package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * History
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class History {
    @JsonProperty("historyId")
    private String historyId = null;

    @JsonProperty("historyName")
    private String historyName = null;

    @JsonProperty("createTime")
    private long createTime;

    @JsonProperty("historyPage")
    private String historyPage = null;

    @JsonProperty("detailId")
    private String detailId = null;

    public History historyId(String historyId) {
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

    public History historyName(String historyName) {
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

    public History createTime(Integer createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 结果集创建时间
     *
     * @return createTime
     **/
    @ApiModelProperty(value = "结果集创建时间")
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getHistoryPage() {
        return historyPage;
    }

    public void setHistoryPage(String historyPage) {
        this.historyPage = historyPage;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history = (History) o;
        return Objects.equals(this.historyId, history.historyId) &&
                Objects.equals(this.historyName, history.historyName) &&
                Objects.equals(this.createTime, history.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyId, historyName, createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class History {\n");

        sb.append("    historyId: ").append(toIndentedString(historyId)).append("\n");
        sb.append("    historyName: ").append(toIndentedString(historyName)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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


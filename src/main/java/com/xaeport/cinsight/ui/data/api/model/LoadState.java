package com.xaeport.cinsight.ui.data.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * LoadState
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class LoadState {
    @JsonProperty("progressLabel")
    private String progressLabel = null;

    @JsonProperty("totalCount")
    private Integer totalCount = null;

    @JsonProperty("successCount")
    private Integer successCount = null;

    @JsonProperty("failCount")
    private Integer failCount = null;

    @JsonProperty("processCount")
    private Integer processCount = null;

    @JsonProperty("startTime")
    private Long startTime = null;

    public LoadState progressLabel(String progressLabel) {
        this.progressLabel = progressLabel;
        return this;
    }

    /**
     * 装载状态文本
     *
     * @return progressLabel
     **/
    @ApiModelProperty(value = "装载状态文本")
    public String getProgressLabel() {
        return progressLabel;
    }

    public void setProgressLabel(String progressLabel) {
        this.progressLabel = progressLabel;
    }

    public LoadState totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * 数据文件总量
     *
     * @return totalCount
     **/
    @ApiModelProperty(value = "数据文件总量")
    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public LoadState successCount(Integer successCount) {
        this.successCount = successCount;
        return this;
    }

    /**
     * 装载成功数量
     *
     * @return successCount
     **/
    @ApiModelProperty(value = "装载成功数量")
    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public LoadState failCount(Integer failCount) {
        this.failCount = failCount;
        return this;
    }

    /**
     * 装载失败数量
     *
     * @return failCount
     **/
    @ApiModelProperty(value = "装载失败数量")
    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public LoadState processCount(Integer processCount) {
        this.processCount = processCount;
        return this;
    }

    /**
     * 已装载数量
     *
     * @return processCount
     **/
    @ApiModelProperty(value = "已装载数量")
    public Integer getProcessCount() {
        return processCount;
    }

    public void setProcessCount(Integer processCount) {
        this.processCount = processCount;
    }

    public LoadState startTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * 装载开始时间
     *
     * @return startTime
     **/
    @ApiModelProperty(value = "装载开始时间")
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoadState loadState = (LoadState) o;
        return Objects.equals(this.progressLabel, loadState.progressLabel) &&
                Objects.equals(this.totalCount, loadState.totalCount) &&
                Objects.equals(this.successCount, loadState.successCount) &&
                Objects.equals(this.failCount, loadState.failCount) &&
                Objects.equals(this.processCount, loadState.processCount) &&
                Objects.equals(this.startTime, loadState.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progressLabel, totalCount, successCount, failCount, processCount, startTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoadState {\n");

        sb.append("    progressLabel: ").append(toIndentedString(progressLabel)).append("\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    successCount: ").append(toIndentedString(successCount)).append("\n");
        sb.append("    failCount: ").append(toIndentedString(failCount)).append("\n");
        sb.append("    processCount: ").append(toIndentedString(processCount)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
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


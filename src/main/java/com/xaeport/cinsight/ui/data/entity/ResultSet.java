package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ResultSet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-01T03:25:43.111Z")

public class ResultSet {
    @JsonProperty("resultsetId")
    private String resultsetId = null;

    @JsonProperty("resultsetName")
    private String resultsetName = null;

    @JsonProperty("resultsetToken")
    private String resultsetToken = null;

    @JsonProperty("createTime")
    private Long createTime = null;

    public ResultSet resultsetId(String resultsetId) {
        this.resultsetId = resultsetId;
        return this;
    }

    /**
     * 结果集id
     *
     * @return resultsetId
     **/
    @ApiModelProperty(value = "结果集id")
    public String getResultsetId() {
        return resultsetId;
    }

    public void setResultsetId(String resultsetId) {
        this.resultsetId = resultsetId;
    }

    public ResultSet resultsetName(String resultsetName) {
        this.resultsetName = resultsetName;
        return this;
    }

    /**
     * 结果集名称
     *
     * @return resultsetName
     **/
    @ApiModelProperty(value = "结果集名称")
    public String getResultsetName() {
        return resultsetName;
    }

    public void setResultsetName(String resultsetName) {
        this.resultsetName = resultsetName;
    }

    public ResultSet resultsetToken(String resultsetToken) {
        this.resultsetToken = resultsetToken;
        return this;
    }

    /**
     * 结果集token
     *
     * @return resultsetToken
     **/
    @ApiModelProperty(value = "结果集token")
    public String getResultsetToken() {
        return resultsetToken;
    }

    public void setResultsetToken(String resultsetToken) {
        this.resultsetToken = resultsetToken;
    }

    public ResultSet createTime(Long createTime) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultSet resultSet = (ResultSet) o;
        return Objects.equals(this.resultsetId, resultSet.resultsetId) &&
                Objects.equals(this.resultsetName, resultSet.resultsetName) &&
                Objects.equals(this.resultsetToken, resultSet.resultsetToken) &&
                Objects.equals(this.createTime, resultSet.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultsetId, resultsetName, resultsetToken, createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultSet {\n");

        sb.append("    resultsetId: ").append(toIndentedString(resultsetId)).append("\n");
        sb.append("    resultsetName: ").append(toIndentedString(resultsetName)).append("\n");
        sb.append("    resultsetToken: ").append(toIndentedString(resultsetToken)).append("\n");
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


package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResultSetDetail
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-01T03:25:43.111Z")

public class ResultSetDetail {
    @JsonProperty("resultsetId")
    private String resultsetId = null;

    @JsonProperty("resultsetName")
    private String resultsetName = null;

    @JsonProperty("resultsetToken")
    private String resultsetToken = null;

    @JsonProperty("createTime")
    private Integer createTime = null;

    @JsonProperty("conditions")
    private List<Condition> conditions = new ArrayList<Condition>();

    public ResultSetDetail resultsetId(String resultsetId) {
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

    public ResultSetDetail resultsetName(String resultsetName) {
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

    public ResultSetDetail resultsetToken(String resultsetToken) {
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

    public ResultSetDetail createTime(Integer createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 结果集创建时间
     *
     * @return createTime
     **/
    @ApiModelProperty(value = "结果集创建时间")
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public ResultSetDetail conditions(List<Condition> conditions) {
        this.conditions = conditions;
        return this;
    }

    public ResultSetDetail addConditionsItem(Condition conditionsItem) {
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
        ResultSetDetail resultSetDetail = (ResultSetDetail) o;
        return Objects.equals(this.resultsetId, resultSetDetail.resultsetId) &&
                Objects.equals(this.resultsetName, resultSetDetail.resultsetName) &&
                Objects.equals(this.resultsetToken, resultSetDetail.resultsetToken) &&
                Objects.equals(this.createTime, resultSetDetail.createTime) &&
                Objects.equals(this.conditions, resultSetDetail.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultsetId, resultsetName, resultsetToken, createTime, conditions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultSetDetail {\n");

        sb.append("    resultsetId: ").append(toIndentedString(resultsetId)).append("\n");
        sb.append("    resultsetName: ").append(toIndentedString(resultsetName)).append("\n");
        sb.append("    resultsetToken: ").append(toIndentedString(resultsetToken)).append("\n");
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


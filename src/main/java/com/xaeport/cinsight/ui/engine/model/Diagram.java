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
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Diagram
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-21T07:16:57.704Z")
public class Diagram {
    @SerializedName("sendTime")
    private String sendTime = null;

    @SerializedName("inboxCount")
    private Integer inboxCount = null;

    @SerializedName("outboxCount")
    private Integer outboxCount = null;

    public Diagram sendTime(String sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    /**
     * 发送日期
     *
     * @return sendTime
     **/
    @ApiModelProperty(example = "null", value = "发送日期")
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Diagram inboxCount(Integer inboxCount) {
        this.inboxCount = inboxCount;
        return this;
    }

    /**
     * 收件数
     *
     * @return inboxCount
     **/
    @ApiModelProperty(example = "null", value = "收件数")
    public Integer getInboxCount() {
        return inboxCount;
    }

    public void setInboxCount(Integer inboxCount) {
        this.inboxCount = inboxCount;
    }

    public Diagram outboxCount(Integer outboxCount) {
        this.outboxCount = outboxCount;
        return this;
    }

    /**
     * 发件数
     *
     * @return outboxCount
     **/
    @ApiModelProperty(example = "null", value = "发件数")
    public Integer getOutboxCount() {
        return outboxCount;
    }

    public void setOutboxCount(Integer outboxCount) {
        this.outboxCount = outboxCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Diagram diagram = (Diagram) o;
        return Objects.equals(this.sendTime, diagram.sendTime) &&
                Objects.equals(this.inboxCount, diagram.inboxCount) &&
                Objects.equals(this.outboxCount, diagram.outboxCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sendTime, inboxCount, outboxCount);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Diagram {\n");

        sb.append("    sendTime: ").append(toIndentedString(sendTime)).append("\n");
        sb.append("    inboxCount: ").append(toIndentedString(inboxCount)).append("\n");
        sb.append("    outboxCount: ").append(toIndentedString(outboxCount)).append("\n");
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


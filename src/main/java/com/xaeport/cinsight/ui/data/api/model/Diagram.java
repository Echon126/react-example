package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Diagram
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Diagram   {
  @JsonProperty("date")
  private String date = null;

  @JsonProperty("inboxCount")
  private Integer inboxCount = null;

  @JsonProperty("outboxCount")
  private Integer outboxCount = null;

  public Diagram date(String date) {
    this.date = date;
    return this;
  }

   /**
   * 日期
   * @return date
  **/
  @ApiModelProperty(value = "日期")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Diagram inboxCount(Integer inboxCount) {
    this.inboxCount = inboxCount;
    return this;
  }

   /**
   * 收件数
   * @return inboxCount
  **/
  @ApiModelProperty(value = "收件数")
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
   * @return outboxCount
  **/
  @ApiModelProperty(value = "发件数")
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
    return Objects.equals(this.date, diagram.date) &&
        Objects.equals(this.inboxCount, diagram.inboxCount) &&
        Objects.equals(this.outboxCount, diagram.outboxCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, inboxCount, outboxCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Diagram {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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


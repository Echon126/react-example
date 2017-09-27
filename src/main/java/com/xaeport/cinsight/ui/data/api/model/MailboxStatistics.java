package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * MailboxStatistics
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class MailboxStatistics   {
  @JsonProperty("inboxCount")
  private Integer inboxCount = null;

  @JsonProperty("outboxCount")
  private Integer outboxCount = null;

  @JsonProperty("draftboxCount")
  private Integer draftboxCount = null;

  @JsonProperty("trashCount")
  private Integer trashCount = null;

  public MailboxStatistics inboxCount(Integer inboxCount) {
    this.inboxCount = inboxCount;
    return this;
  }

   /**
   * 收件箱邮件数量
   * @return inboxCount
  **/
  @ApiModelProperty(value = "收件箱邮件数量")
  public Integer getInboxCount() {
    return inboxCount;
  }

  public void setInboxCount(Integer inboxCount) {
    this.inboxCount = inboxCount;
  }

  public MailboxStatistics outboxCount(Integer outboxCount) {
    this.outboxCount = outboxCount;
    return this;
  }

   /**
   * 发件箱邮件数量
   * @return outboxCount
  **/
  @ApiModelProperty(value = "发件箱邮件数量")
  public Integer getOutboxCount() {
    return outboxCount;
  }

  public void setOutboxCount(Integer outboxCount) {
    this.outboxCount = outboxCount;
  }

  public MailboxStatistics draftboxCount(Integer draftboxCount) {
    this.draftboxCount = draftboxCount;
    return this;
  }

   /**
   * 草稿箱邮件数量
   * @return draftboxCount
  **/
  @ApiModelProperty(value = "草稿箱邮件数量")
  public Integer getDraftboxCount() {
    return draftboxCount;
  }

  public void setDraftboxCount(Integer draftboxCount) {
    this.draftboxCount = draftboxCount;
  }

  public MailboxStatistics trashCount(Integer trashCount) {
    this.trashCount = trashCount;
    return this;
  }

   /**
   * 垃圾箱邮件数量
   * @return trashCount
  **/
  @ApiModelProperty(value = "垃圾箱邮件数量")
  public Integer getTrashCount() {
    return trashCount;
  }

  public void setTrashCount(Integer trashCount) {
    this.trashCount = trashCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailboxStatistics mailboxStatistics = (MailboxStatistics) o;
    return Objects.equals(this.inboxCount, mailboxStatistics.inboxCount) &&
        Objects.equals(this.outboxCount, mailboxStatistics.outboxCount) &&
        Objects.equals(this.draftboxCount, mailboxStatistics.draftboxCount) &&
        Objects.equals(this.trashCount, mailboxStatistics.trashCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inboxCount, outboxCount, draftboxCount, trashCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailboxStatistics {\n");
    
    sb.append("    inboxCount: ").append(toIndentedString(inboxCount)).append("\n");
    sb.append("    outboxCount: ").append(toIndentedString(outboxCount)).append("\n");
    sb.append("    draftboxCount: ").append(toIndentedString(draftboxCount)).append("\n");
    sb.append("    trashCount: ").append(toIndentedString(trashCount)).append("\n");
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


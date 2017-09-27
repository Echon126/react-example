package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Mailbox
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Mailbox   {
  @JsonProperty("mailId")
  private String mailId = null;

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("sendTime")
  private Integer sendTime = null;

  @JsonProperty("tagCount")
  private Integer tagCount = null;

  @JsonProperty("attachmentCount")
  private Integer attachmentCount = null;

  public Mailbox mailId(String mailId) {
    this.mailId = mailId;
    return this;
  }

   /**
   * 邮件id
   * @return mailId
  **/
  @ApiModelProperty(value = "邮件id")
  public String getMailId() {
    return mailId;
  }

  public void setMailId(String mailId) {
    this.mailId = mailId;
  }

  public Mailbox subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * 邮件主题
   * @return subject
  **/
  @ApiModelProperty(value = "邮件主题")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Mailbox sendTime(Integer sendTime) {
    this.sendTime = sendTime;
    return this;
  }

   /**
   * 发送时间
   * @return sendTime
  **/
  @ApiModelProperty(value = "发送时间")
  public Integer getSendTime() {
    return sendTime;
  }

  public void setSendTime(Integer sendTime) {
    this.sendTime = sendTime;
  }

  public Mailbox tagCount(Integer tagCount) {
    this.tagCount = tagCount;
    return this;
  }

   /**
   * 标签数量
   * @return tagCount
  **/
  @ApiModelProperty(value = "标签数量")
  public Integer getTagCount() {
    return tagCount;
  }

  public void setTagCount(Integer tagCount) {
    this.tagCount = tagCount;
  }

  public Mailbox attachmentCount(Integer attachmentCount) {
    this.attachmentCount = attachmentCount;
    return this;
  }

   /**
   * 附件数量
   * @return attachmentCount
  **/
  @ApiModelProperty(value = "附件数量")
  public Integer getAttachmentCount() {
    return attachmentCount;
  }

  public void setAttachmentCount(Integer attachmentCount) {
    this.attachmentCount = attachmentCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mailbox mailbox = (Mailbox) o;
    return Objects.equals(this.mailId, mailbox.mailId) &&
        Objects.equals(this.subject, mailbox.subject) &&
        Objects.equals(this.sendTime, mailbox.sendTime) &&
        Objects.equals(this.tagCount, mailbox.tagCount) &&
        Objects.equals(this.attachmentCount, mailbox.attachmentCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mailId, subject, sendTime, tagCount, attachmentCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mailbox {\n");
    
    sb.append("    mailId: ").append(toIndentedString(mailId)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    sendTime: ").append(toIndentedString(sendTime)).append("\n");
    sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
    sb.append("    attachmentCount: ").append(toIndentedString(attachmentCount)).append("\n");
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


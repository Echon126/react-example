package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * MailList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class MailList   {
  @JsonProperty("mailId")
  private String mailId = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("sendTime")
  private long sendTime ;

  @JsonProperty("sessionCount")
  private Integer sessionCount = null;

  @JsonProperty("attachmentCount")
  private Integer attachmentCount = null;

  @JsonProperty("tagCount")
  private Integer tagCount = null;

  public MailList mailId(String mailId) {
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

  public MailList from(String from) {
    this.from = from;
    return this;
  }

   /**
   * 发件人邮箱
   * @return from
  **/
  @ApiModelProperty(value = "发件人邮箱")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public MailList subject(String subject) {
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

  public MailList sendTime(Integer sendTime) {
    this.sendTime = sendTime;
    return this;
  }

   /**
   * 发送时间
   * @return sendTime
  **/
  @ApiModelProperty(value = "发送时间")
  public long getSendTime() {
    return sendTime;
  }

  public void setSendTime(long sendTime) {
    this.sendTime = sendTime;
  }

  public MailList sessionCount(Integer sessionCount) {
    this.sessionCount = sessionCount;
    return this;
  }

   /**
   * 会话数目
   * @return sessionCount
  **/
  @ApiModelProperty(value = "会话数目")
  public Integer getSessionCount() {
    return sessionCount;
  }

  public void setSessionCount(Integer sessionCount) {
    this.sessionCount = sessionCount;
  }

  public MailList attachmentCount(Integer attachmentCount) {
    this.attachmentCount = attachmentCount;
    return this;
  }

   /**
   * 附件数目
   * @return attachmentCount
  **/
  @ApiModelProperty(value = "附件数目")
  public Integer getAttachmentCount() {
    return attachmentCount;
  }

  public void setAttachmentCount(Integer attachmentCount) {
    this.attachmentCount = attachmentCount;
  }

  public MailList tagCount(Integer tagCount) {
    this.tagCount = tagCount;
    return this;
  }

   /**
   * 标签数目
   * @return tagCount
  **/
  @ApiModelProperty(value = "标签数目")
  public Integer getTagCount() {
    return tagCount;
  }

  public void setTagCount(Integer tagCount) {
    this.tagCount = tagCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailList mailList = (MailList) o;
    return Objects.equals(this.mailId, mailList.mailId) &&
        Objects.equals(this.from, mailList.from) &&
        Objects.equals(this.subject, mailList.subject) &&
        Objects.equals(this.sendTime, mailList.sendTime) &&
        Objects.equals(this.sessionCount, mailList.sessionCount) &&
        Objects.equals(this.attachmentCount, mailList.attachmentCount) &&
        Objects.equals(this.tagCount, mailList.tagCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mailId, from, subject, sendTime, sessionCount, attachmentCount, tagCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailList {\n");
    
    sb.append("    mailId: ").append(toIndentedString(mailId)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    sendTime: ").append(toIndentedString(sendTime)).append("\n");
    sb.append("    sessionCount: ").append(toIndentedString(sessionCount)).append("\n");
    sb.append("    attachmentCount: ").append(toIndentedString(attachmentCount)).append("\n");
    sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
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


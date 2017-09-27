package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
/**
 * MailDetail
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class MailDetail   {
  @JsonProperty("mailId")
  private String mailId = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("to")
  private List<MailContact> to = new ArrayList<MailContact>();

  @JsonProperty("cc")
  private List<MailContact> cc = new ArrayList<MailContact>();

  @JsonProperty("bcc")
  private List<MailContact> bcc = new ArrayList<MailContact>();

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("sendTime")
  private long sendTime ;

  @JsonProperty("sendTimezone")
  private Integer sendTimezone = null;

  @JsonProperty("mailContent")
  private String mailContent = null;

  @JsonProperty("attachments")
  private List<Attachment> attachments = new ArrayList<Attachment>();

  @JsonProperty("tags")
  private List<UseTag> tags = new ArrayList<UseTag>();

  @JsonProperty("notes")
  private String notes = null;

  public MailDetail mailId(String mailId) {
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

  public MailDetail from(String from) {
    this.from = from;
    return this;
  }

  /**
   * 发件人
   * @return from
   **/
  @ApiModelProperty(value = "发件人")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public MailDetail to(List<MailContact> to) {
    this.to = to;
    return this;
  }

  public MailDetail addToItem(MailContact toItem) {
    this.to.add(toItem);
    return this;
  }

  /**
   * 收件人
   * @return to
   **/
  @ApiModelProperty(value = "收件人")
  public List<MailContact> getTo() {
    return to;
  }

  public void setTo(List<MailContact> to) {
    this.to = to;
  }

  public MailDetail cc(List<MailContact> cc) {
    this.cc = cc;
    return this;
  }

  public MailDetail addCcItem(MailContact ccItem) {
    this.cc.add(ccItem);
    return this;
  }

  /**
   * 抄送
   * @return cc
   **/
  @ApiModelProperty(value = "抄送")
  public List<MailContact> getCc() {
    return cc;
  }

  public void setCc(List<MailContact> cc) {
    this.cc = cc;
  }

  public MailDetail bcc(List<MailContact> bcc) {
    this.bcc = bcc;
    return this;
  }

  public MailDetail addBccItem(MailContact bccItem) {
    this.bcc.add(bccItem);
    return this;
  }

  /**
   * 暗送
   * @return bcc
   **/
  @ApiModelProperty(value = "暗送")
  public List<MailContact> getBcc() {
    return bcc;
  }

  public void setBcc(List<MailContact> bcc) {
    this.bcc = bcc;
  }

  public MailDetail subject(String subject) {
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

  public MailDetail sendTime(long sendTime) {
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

  public void setSendTime(Integer sendTime) {
    this.sendTime = sendTime;
  }

  public MailDetail sendTimezone(Integer sendTimezone) {
    this.sendTimezone = sendTimezone;
    return this;
  }

  /**
   * 发送时区
   * @return sendTimezone
   **/
  @ApiModelProperty(value = "发送时区")
  public Integer getSendTimezone() {
    return sendTimezone;
  }

  public void setSendTimezone(Integer sendTimezone) {
    this.sendTimezone = sendTimezone;
  }

  public MailDetail mailContent(String mailContent) {
    this.mailContent = mailContent;
    return this;
  }

  /**
   * 邮件内容
   * @return mailContent
   **/
  @ApiModelProperty(value = "邮件内容")
  public String getMailContent() {
    return mailContent;
  }

  public void setMailContent(String mailContent) {
    this.mailContent = mailContent;
  }

  public MailDetail attachments(List<Attachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public MailDetail addAttachmentsItem(Attachment attachmentsItem) {
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * 附件列表
   * @return attachments
   **/
  @ApiModelProperty(value = "附件列表")
  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }

  public MailDetail tags(List<UseTag> tags) {
    this.tags = tags;
    return this;
  }

  public MailDetail addTagsItem(UseTag tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * 标签列表
   * @return tags
   **/
  @ApiModelProperty(value = "标签列表")
  public List<UseTag> getTags() {
    return tags;
  }

  public void setTags(List<UseTag> tags) {
    this.tags = tags;
  }

  public MailDetail notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * 批注内容
   * @return notes
   **/
  @ApiModelProperty(value = "批注内容")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailDetail mailDetail = (MailDetail) o;
    return Objects.equals(this.mailId, mailDetail.mailId) &&
            Objects.equals(this.from, mailDetail.from) &&
            Objects.equals(this.to, mailDetail.to) &&
            Objects.equals(this.cc, mailDetail.cc) &&
            Objects.equals(this.bcc, mailDetail.bcc) &&
            Objects.equals(this.subject, mailDetail.subject) &&
            Objects.equals(this.sendTime, mailDetail.sendTime) &&
            Objects.equals(this.sendTimezone, mailDetail.sendTimezone) &&
            Objects.equals(this.mailContent, mailDetail.mailContent) &&
            Objects.equals(this.attachments, mailDetail.attachments) &&
            Objects.equals(this.tags, mailDetail.tags) &&
            Objects.equals(this.notes, mailDetail.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mailId, from, to, cc, bcc, subject, sendTime, sendTimezone, mailContent, attachments, tags, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailDetail {\n");

    sb.append("    mailId: ").append(toIndentedString(mailId)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    bcc: ").append(toIndentedString(bcc)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    sendTime: ").append(toIndentedString(sendTime)).append("\n");
    sb.append("    sendTimezone: ").append(toIndentedString(sendTimezone)).append("\n");
    sb.append("    mailContent: ").append(toIndentedString(mailContent)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}




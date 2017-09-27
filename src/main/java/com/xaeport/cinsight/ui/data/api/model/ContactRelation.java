package com.xaeport.cinsight.ui.data.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;
/**
 * ContactRelation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-02T03:03:07.130Z")

public class ContactRelation   {
  @JsonProperty("mailboxId")
  private String mailboxId = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("count")
  private String count = null;

  public ContactRelation mailboxId(String mailboxId) {
    this.mailboxId = mailboxId;
    return this;
  }

  /**
   * 邮箱ID
   * @return mailboxId
   **/
  @ApiModelProperty(value = "邮箱ID")
  public String getMailboxId() {
    return mailboxId;
  }

  public void setMailboxId(String mailboxId) {
    this.mailboxId = mailboxId;
  }

  public ContactRelation to(String to) {
    this.to = to;
    return this;
  }

  /**
   * 关系人
   * @return to
   **/
  @ApiModelProperty(value = "关系人")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public ContactRelation count(String count) {
    this.count = count;
    return this;
  }

  /**
   * 来往邮件数
   * @return count
   **/
  @ApiModelProperty(value = "来往邮件数")
  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactRelation contactRelation = (ContactRelation) o;
    return Objects.equals(this.mailboxId, contactRelation.mailboxId) &&
            Objects.equals(this.to, contactRelation.to) &&
            Objects.equals(this.count, contactRelation.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mailboxId, to, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactRelation {\n");

    sb.append("    mailboxId: ").append(toIndentedString(mailboxId)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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


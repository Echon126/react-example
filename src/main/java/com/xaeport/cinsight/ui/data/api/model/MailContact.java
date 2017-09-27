package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * MailContact
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-17T03:23:41.083Z")

public class MailContact   {
  @JsonProperty("mailAddress")
  private String mailAddress = null;

  public MailContact mailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
    return this;
  }

   /**
   * 邮箱地址
   * @return mailAddress
  **/
  @ApiModelProperty(value = "邮箱地址")
  public String getMailAddress() {
    return mailAddress;
  }

  public void setMailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailContact mailContact = (MailContact) o;
    return Objects.equals(this.mailAddress, mailContact.mailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mailAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailContact {\n");
    
    sb.append("    mailAddress: ").append(toIndentedString(mailAddress)).append("\n");
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


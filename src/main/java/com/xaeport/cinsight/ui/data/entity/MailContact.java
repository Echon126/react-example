/*
 * 案件分析系统后台引擎
 * 案件分析系统后台引擎
 *
 * OpenAPI spec version: 1.0.0
 * Contact: cinsight@xaeport.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.xaeport.cinsight.ui.data.entity;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * MailContact
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-26T03:02:51.444Z")
public class MailContact {
  @SerializedName("mailAddress")
  private String mailAddress = null;

  public MailContact mailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
    return this;
  }

   /**
   * 邮箱地址
   * @return mailAddress
  **/
  @ApiModelProperty(example = "null", value = "邮箱地址")
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


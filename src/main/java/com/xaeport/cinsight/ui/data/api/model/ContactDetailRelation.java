package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * ContactDetailRelation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class ContactDetailRelation   {
  @JsonProperty("contactMailBox")
  private String contactMailBox = null;

  @JsonProperty("contacCount")
  private Integer contacCount = null;

  public ContactDetailRelation contactMailBox(String contactMailBox) {
    this.contactMailBox = contactMailBox;
    return this;
  }

   /**
   * 关系邮箱
   * @return contactMailBox
  **/
  @ApiModelProperty(value = "关系邮箱")
  public String getContactMailBox() {
    return contactMailBox;
  }

  public void setContactMailBox(String contactMailBox) {
    this.contactMailBox = contactMailBox;
  }

  public ContactDetailRelation contacCount(Integer contacCount) {
    this.contacCount = contacCount;
    return this;
  }

   /**
   * 关系会话总数
   * @return contacCount
  **/
  @ApiModelProperty(value = "关系会话总数")
  public Integer getContacCount() {
    return contacCount;
  }

  public void setContacCount(Integer contacCount) {
    this.contacCount = contacCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactDetailRelation contactDetailRelation = (ContactDetailRelation) o;
    return Objects.equals(this.contactMailBox, contactDetailRelation.contactMailBox) &&
        Objects.equals(this.contacCount, contactDetailRelation.contacCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactMailBox, contacCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactDetailRelation {\n");
    
    sb.append("    contactMailBox: ").append(toIndentedString(contactMailBox)).append("\n");
    sb.append("    contacCount: ").append(toIndentedString(contacCount)).append("\n");
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


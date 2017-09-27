package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * UseTag
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class UseTag   {
  @JsonProperty("typeName")
  private String typeName = null;

  @JsonProperty("typeType")
  private String typeType = null;

  @JsonProperty("typeIcon")
  private String typeIcon = null;

  public UseTag typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

   /**
   * 标签名称
   * @return typeName
  **/
  @ApiModelProperty(value = "标签名称")
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public UseTag typeType(String typeType) {
    this.typeType = typeType;
    return this;
  }

   /**
   * 标签类型
   * @return typeType
  **/
  @ApiModelProperty(value = "标签类型")
  public String getTypeType() {
    return typeType;
  }

  public void setTypeType(String typeType) {
    this.typeType = typeType;
  }

  public UseTag typeIcon(String typeIcon) {
    this.typeIcon = typeIcon;
    return this;
  }

   /**
   * 标签图标名称
   * @return typeIcon
  **/
  @ApiModelProperty(value = "标签图标名称")
  public String getTypeIcon() {
    return typeIcon;
  }

  public void setTypeIcon(String typeIcon) {
    this.typeIcon = typeIcon;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UseTag useTag = (UseTag) o;
    return Objects.equals(this.typeName, useTag.typeName) &&
        Objects.equals(this.typeType, useTag.typeType) &&
        Objects.equals(this.typeIcon, useTag.typeIcon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeName, typeType, typeIcon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UseTag {\n");
    
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
    sb.append("    typeType: ").append(toIndentedString(typeType)).append("\n");
    sb.append("    typeIcon: ").append(toIndentedString(typeIcon)).append("\n");
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


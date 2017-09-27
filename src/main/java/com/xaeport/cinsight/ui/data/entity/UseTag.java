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
 * UseTag
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-26T03:02:51.444Z")
public class UseTag {
  @SerializedName("typeIcon")
  private String typeIcon = null;

  @SerializedName("typeName")
  private String typeName = null;

  @SerializedName("typeType")
  private String typeType = null;

  public UseTag typeIcon(String typeIcon) {
    this.typeIcon = typeIcon;
    return this;
  }

   /**
   * 标签图标名称
   * @return typeIcon
  **/
  @ApiModelProperty(example = "null", value = "标签图标名称")
  public String getTypeIcon() {
    return typeIcon;
  }

  public void setTypeIcon(String typeIcon) {
    this.typeIcon = typeIcon;
  }

  public UseTag typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

   /**
   * 标签名称
   * @return typeName
  **/
  @ApiModelProperty(example = "null", value = "标签名称")
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
  @ApiModelProperty(example = "null", value = "标签类型")
  public String getTypeType() {
    return typeType;
  }

  public void setTypeType(String typeType) {
    this.typeType = typeType;
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
    return Objects.equals(this.typeIcon, useTag.typeIcon) &&
        Objects.equals(this.typeName, useTag.typeName) &&
        Objects.equals(this.typeType, useTag.typeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeIcon, typeName, typeType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UseTag {\n");
    
    sb.append("    typeIcon: ").append(toIndentedString(typeIcon)).append("\n");
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
    sb.append("    typeType: ").append(toIndentedString(typeType)).append("\n");
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

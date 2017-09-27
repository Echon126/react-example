package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * TagChild
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class TagChild   {
  @JsonProperty("tagName")
  private String tagName = null;

  @JsonProperty("hitCount")
  private Integer hitCount = null;

  public TagChild tagName(String tagName) {
    this.tagName = tagName;
    return this;
  }

   /**
   * 标签名称
   * @return tagName
  **/
  @ApiModelProperty(value = "标签名称")
  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public TagChild hitCount(Integer hitCount) {
    this.hitCount = hitCount;
    return this;
  }

   /**
   * 命中数
   * @return hitCount
  **/
  @ApiModelProperty(value = "命中数")
  public Integer getHitCount() {
    return hitCount;
  }

  public void setHitCount(Integer hitCount) {
    this.hitCount = hitCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagChild tagChild = (TagChild) o;
    return Objects.equals(this.tagName, tagChild.tagName) &&
        Objects.equals(this.hitCount, tagChild.hitCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagName, hitCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagChild {\n");
    
    sb.append("    tagName: ").append(toIndentedString(tagName)).append("\n");
    sb.append("    hitCount: ").append(toIndentedString(hitCount)).append("\n");
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


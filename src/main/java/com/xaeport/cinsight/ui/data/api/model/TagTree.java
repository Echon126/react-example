package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
/**
 * TagTree
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class TagTree {
  @JsonProperty("typeName")
  private String typeName = null;

  @JsonProperty("typeIcon")
  private String typeIcon = null;

  @JsonProperty("tags")
  private List<TagChild> tags = new ArrayList<TagChild>();

  public TagTree typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

   /**
   * 标签类型
   * @return typeName
  **/
  @ApiModelProperty(value = "标签类型")
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public TagTree typeIcon(String typeIcon) {
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

  public TagTree tags(List<TagChild> tags) {
    this.tags = tags;
    return this;
  }

  public TagTree addTagsItem(TagChild tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * 标签类型，取值=用户、信息、领域、姓名、文件
   * @return tags
  **/
  @ApiModelProperty(value = "标签类型，取值=用户、信息、领域、姓名、文件")
  public List<TagChild> getTags() {
    return tags;
  }

  public void setTags(List<TagChild> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagTree tag = (TagTree) o;
    return Objects.equals(this.typeName, tag.typeName) &&
        Objects.equals(this.typeIcon, tag.typeIcon) &&
        Objects.equals(this.tags, tag.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeName, typeIcon, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagTree {\n");
    
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
    sb.append("    typeIcon: ").append(toIndentedString(typeIcon)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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


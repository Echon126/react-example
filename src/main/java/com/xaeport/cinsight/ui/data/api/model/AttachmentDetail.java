package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
/**
 * AttachmentDetail
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class AttachmentDetail   {
  @JsonProperty("attachmentId")
  private String attachmentId = null;

  @JsonProperty("attachmentName")
  private String attachmentName = null;

  @JsonProperty("attachmentSize")
  private Integer attachmentSize = null;

  @JsonProperty("attachmentContent")
  private Integer attachmentContent = null;

  @JsonProperty("fileType")
  private String fileType = null;

  @JsonProperty("filePath")
  private String filePath = null;

  @JsonProperty("createTime")
  private Integer createTime = null;

  @JsonProperty("attributes")
  private List<Attribute> attributes = new ArrayList<Attribute>();

  @JsonProperty("tags")
  private List<UseTag> tags = new ArrayList<UseTag>();

  @JsonProperty("notes")
  private String notes = null;

  public AttachmentDetail attachmentId(String attachmentId) {
    this.attachmentId = attachmentId;
    return this;
  }

   /**
   * 附件id
   * @return attachmentId
  **/
  @ApiModelProperty(value = "附件id")
  public String getAttachmentId() {
    return attachmentId;
  }

  public void setAttachmentId(String attachmentId) {
    this.attachmentId = attachmentId;
  }

  public AttachmentDetail attachmentName(String attachmentName) {
    this.attachmentName = attachmentName;
    return this;
  }

   /**
   * 附件名称
   * @return attachmentName
  **/
  @ApiModelProperty(value = "附件名称")
  public String getAttachmentName() {
    return attachmentName;
  }

  public void setAttachmentName(String attachmentName) {
    this.attachmentName = attachmentName;
  }

  public AttachmentDetail attachmentSize(Integer attachmentSize) {
    this.attachmentSize = attachmentSize;
    return this;
  }

   /**
   * 附件大小
   * @return attachmentSize
  **/
  @ApiModelProperty(value = "附件大小")
  public Integer getAttachmentSize() {
    return attachmentSize;
  }

  public void setAttachmentSize(Integer attachmentSize) {
    this.attachmentSize = attachmentSize;
  }

  public AttachmentDetail attachmentContent(Integer attachmentContent) {
    this.attachmentContent = attachmentContent;
    return this;
  }

   /**
   * 附件内容（图片路径）
   * @return attachmentContent
  **/
  @ApiModelProperty(value = "附件内容（图片路径）")
  public Integer getAttachmentContent() {
    return attachmentContent;
  }

  public void setAttachmentContent(Integer attachmentContent) {
    this.attachmentContent = attachmentContent;
  }

  public AttachmentDetail fileType(String fileType) {
    this.fileType = fileType;
    return this;
  }

   /**
   * 文件类型
   * @return fileType
  **/
  @ApiModelProperty(value = "文件类型")
  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public AttachmentDetail filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

   /**
   * 文件路径
   * @return filePath
  **/
  @ApiModelProperty(value = "文件路径")
  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public AttachmentDetail createTime(Integer createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * 创建时间
   * @return createTime
  **/
  @ApiModelProperty(value = "创建时间")
  public Integer getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Integer createTime) {
    this.createTime = createTime;
  }

  public AttachmentDetail attributes(List<Attribute> attributes) {
    this.attributes = attributes;
    return this;
  }

  public AttachmentDetail addAttributesItem(Attribute attributesItem) {
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * 附件属性
   * @return attributes
  **/
  @ApiModelProperty(value = "附件属性")
  public List<Attribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
  }

  public AttachmentDetail tags(List<UseTag> tags) {
    this.tags = tags;
    return this;
  }

  public AttachmentDetail addTagsItem(UseTag tagsItem) {
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

  public AttachmentDetail notes(String notes) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentDetail attachmentDetail = (AttachmentDetail) o;
    return Objects.equals(this.attachmentId, attachmentDetail.attachmentId) &&
        Objects.equals(this.attachmentName, attachmentDetail.attachmentName) &&
        Objects.equals(this.attachmentSize, attachmentDetail.attachmentSize) &&
        Objects.equals(this.attachmentContent, attachmentDetail.attachmentContent) &&
        Objects.equals(this.fileType, attachmentDetail.fileType) &&
        Objects.equals(this.filePath, attachmentDetail.filePath) &&
        Objects.equals(this.createTime, attachmentDetail.createTime) &&
        Objects.equals(this.attributes, attachmentDetail.attributes) &&
        Objects.equals(this.tags, attachmentDetail.tags) &&
        Objects.equals(this.notes, attachmentDetail.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachmentId, attachmentName, attachmentSize, attachmentContent, fileType, filePath, createTime, attributes, tags, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentDetail {\n");
    
    sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
    sb.append("    attachmentName: ").append(toIndentedString(attachmentName)).append("\n");
    sb.append("    attachmentSize: ").append(toIndentedString(attachmentSize)).append("\n");
    sb.append("    attachmentContent: ").append(toIndentedString(attachmentContent)).append("\n");
    sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
    sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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


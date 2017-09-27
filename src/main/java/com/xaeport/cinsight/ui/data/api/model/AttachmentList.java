package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * AttachmentList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class AttachmentList   {
  @JsonProperty("attachmentId")
  private String attachmentId = null;

  @JsonProperty("attachmentName")
  private String attachmentName = null;

  @JsonProperty("attachmentSize")
  private Integer attachmentSize = null;

  @JsonProperty("tagCount")
  private Integer tagCount = null;

  @JsonProperty("refrenceCount")
  private Integer refrenceCount = null;

  public AttachmentList attachmentId(String attachmentId) {
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

  public AttachmentList attachmentName(String attachmentName) {
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

  public AttachmentList attachmentSize(Integer attachmentSize) {
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

  public AttachmentList tagCount(Integer tagCount) {
    this.tagCount = tagCount;
    return this;
  }

   /**
   * 标签数目
   * @return tagCount
  **/
  @ApiModelProperty(value = "标签数目")
  public Integer getTagCount() {
    return tagCount;
  }

  public void setTagCount(Integer tagCount) {
    this.tagCount = tagCount;
  }

  public AttachmentList refrenceCount(Integer refrenceCount) {
    this.refrenceCount = refrenceCount;
    return this;
  }

   /**
   * 转发次数
   * @return refrenceCount
  **/
  @ApiModelProperty(value = "转发次数")
  public Integer getRefrenceCount() {
    return refrenceCount;
  }

  public void setRefrenceCount(Integer refrenceCount) {
    this.refrenceCount = refrenceCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentList attachmentList = (AttachmentList) o;
    return Objects.equals(this.attachmentId, attachmentList.attachmentId) &&
        Objects.equals(this.attachmentName, attachmentList.attachmentName) &&
        Objects.equals(this.attachmentSize, attachmentList.attachmentSize) &&
        Objects.equals(this.tagCount, attachmentList.tagCount) &&
        Objects.equals(this.refrenceCount, attachmentList.refrenceCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachmentId, attachmentName, attachmentSize, tagCount, refrenceCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentList {\n");
    
    sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
    sb.append("    attachmentName: ").append(toIndentedString(attachmentName)).append("\n");
    sb.append("    attachmentSize: ").append(toIndentedString(attachmentSize)).append("\n");
    sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
    sb.append("    refrenceCount: ").append(toIndentedString(refrenceCount)).append("\n");
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


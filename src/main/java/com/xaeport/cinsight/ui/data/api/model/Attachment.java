package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Attachment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Attachment   {
  @JsonProperty("attachmentId")
  private String attachmentId = null;

  @JsonProperty("attachmentName")
  private String attachmentName = null;

  @JsonProperty("attachmentSize")
  private Integer attachmentSize = null;

  @JsonProperty("attachmentType")
  private String attachmentType = null;

  @JsonProperty("attachmentPath")
  private String attachmentPath = null;

  public Attachment attachmentId(String attachmentId) {
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

  public Attachment attachmentName(String attachmentName) {
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

  public Attachment attachmentSize(Integer attachmentSize) {
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

  public Attachment attachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
    return this;
  }

   /**
   * 附件类型
   * @return attachmentType
  **/
  @ApiModelProperty(value = "附件类型")
  public String getAttachmentType() {
    return attachmentType;
  }

  public void setAttachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
  }

  public Attachment attachmentPath(String attachmentPath) {
    this.attachmentPath = attachmentPath;
    return this;
  }

   /**
   * 附件路径
   * @return attachmentPath
  **/
  @ApiModelProperty(value = "附件路径")
  public String getAttachmentPath() {
    return attachmentPath;
  }

  public void setAttachmentPath(String attachmentPath) {
    this.attachmentPath = attachmentPath;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.attachmentId, attachment.attachmentId) &&
        Objects.equals(this.attachmentName, attachment.attachmentName) &&
        Objects.equals(this.attachmentSize, attachment.attachmentSize) &&
        Objects.equals(this.attachmentType, attachment.attachmentType) &&
        Objects.equals(this.attachmentPath, attachment.attachmentPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachmentId, attachmentName, attachmentSize, attachmentType, attachmentPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    
    sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
    sb.append("    attachmentName: ").append(toIndentedString(attachmentName)).append("\n");
    sb.append("    attachmentSize: ").append(toIndentedString(attachmentSize)).append("\n");
    sb.append("    attachmentType: ").append(toIndentedString(attachmentType)).append("\n");
    sb.append("    attachmentPath: ").append(toIndentedString(attachmentPath)).append("\n");
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


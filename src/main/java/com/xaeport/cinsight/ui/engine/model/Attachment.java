/*
 * 案件分析引擎
 * 案件分析引擎
 *
 * OpenAPI spec version: 1.0.0
 * Contact: cinsight@xaeport.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.xaeport.cinsight.ui.engine.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Attachment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-21T07:16:57.704Z")
public class Attachment {
    @SerializedName("attachmentId")
    private String attachmentId = null;

    @SerializedName("mailId")
    private String mailId = null;

    @SerializedName("attachmentName")
    private String attachmentName = null;

    @SerializedName("attachmentSize")
    private Integer attachmentSize = null;

    @SerializedName("refrenceCount")
    private Integer refrenceCount = null;

    @SerializedName("tag")
    private String tag = null;

    @SerializedName("tagCount")
    private Integer tagCount = null;

    @SerializedName("sysTagCount")
    private Integer sysTagCount = null;

    @SerializedName("note")
    private String note = null;

    @SerializedName("filePath")
    private String filePath = null;

    @SerializedName("gps")
    private String gps = null;

    @SerializedName("camera")
    private String camera = null;

    @SerializedName("author")
    private String author = null;

    @SerializedName("createTime")
    private Long createTime = null;

    @SerializedName("fileType")
    private String fileType = null;

    @SerializedName("company")
    private String company = null;

    @SerializedName("shotTime")
    private Long shotTime = null;

    @SerializedName("editTime")
    private Long editTime = null;

    @SerializedName("total")
    private Integer total = null;

    @SerializedName("hashcode")
    private Integer hashcode = null;

    @SerializedName("content")
    private String content = null;

    public Attachment attachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
        return this;
    }

    /**
     * 附件 Id
     *
     * @return attachmentId
     **/
    @ApiModelProperty(example = "null", value = "附件 Id")
    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Attachment mailId(String mailId) {
        this.mailId = mailId;
        return this;
    }

    /**
     * 所属邮件
     *
     * @return mailId
     **/
    @ApiModelProperty(example = "null", value = "所属邮件")
    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Attachment attachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
        return this;
    }

    /**
     * 附件名称
     *
     * @return attachmentName
     **/
    @ApiModelProperty(example = "null", value = "附件名称")
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
     *
     * @return attachmentSize
     **/
    @ApiModelProperty(example = "null", value = "附件大小")
    public Integer getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(Integer attachmentSize) {
        this.attachmentSize = attachmentSize;
    }

    public Attachment refrenceCount(Integer refrenceCount) {
        this.refrenceCount = refrenceCount;
        return this;
    }

    /**
     * 转发次数
     *
     * @return refrenceCount
     **/
    @ApiModelProperty(example = "null", value = "转发次数")
    public Integer getRefrenceCount() {
        return refrenceCount;
    }

    public void setRefrenceCount(Integer refrenceCount) {
        this.refrenceCount = refrenceCount;
    }

    public Attachment tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * 标签
     *
     * @return tag
     **/
    @ApiModelProperty(example = "null", value = "标签")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Attachment tagCount(Integer tagCount) {
        this.tagCount = tagCount;
        return this;
    }

    /**
     * 标签数目
     *
     * @return tagCount
     **/
    @ApiModelProperty(example = "null", value = "标签数目")
    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    public Attachment sysTagCount(Integer sysTagCount) {
        this.sysTagCount = sysTagCount;
        return this;
    }

    /**
     * 初始系统标签数量
     *
     * @return sysTagCount
     **/
    @ApiModelProperty(example = "null", value = "初始系统标签数量")
    public Integer getSysTagCount() {
        return sysTagCount;
    }

    public void setSysTagCount(Integer sysTagCount) {
        this.sysTagCount = sysTagCount;
    }

    public Attachment note(String note) {
        this.note = note;
        return this;
    }

    /**
     * 批注
     *
     * @return note
     **/
    @ApiModelProperty(example = "null", value = "批注")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Attachment filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * 附件在工作区中位置
     *
     * @return filePath
     **/
    @ApiModelProperty(example = "null", value = "附件在工作区中位置")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Attachment gps(String gps) {
        this.gps = gps;
        return this;
    }

    /**
     * 经纬度
     *
     * @return gps
     **/
    @ApiModelProperty(example = "null", value = "经纬度")
    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Attachment camera(String camera) {
        this.camera = camera;
        return this;
    }

    /**
     * 相机类型
     *
     * @return camera
     **/
    @ApiModelProperty(example = "null", value = "相机类型")
    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Attachment author(String author) {
        this.author = author;
        return this;
    }

    /**
     * 文档作者
     *
     * @return author
     **/
    @ApiModelProperty(example = "null", value = "文档作者")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Attachment createTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 创建时间
     *
     * @return createTime
     **/
    @ApiModelProperty(example = "null", value = "创建时间")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Attachment fileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    /**
     * 文件类型
     *
     * @return fileType
     **/
    @ApiModelProperty(example = "null", value = "文件类型")
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Attachment company(String company) {
        this.company = company;
        return this;
    }

    /**
     * 公司
     *
     * @return company
     **/
    @ApiModelProperty(example = "null", value = "公司")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Attachment shotTime(Long shotTime) {
        this.shotTime = shotTime;
        return this;
    }

    /**
     * 拍摄时间
     *
     * @return shotTime
     **/
    @ApiModelProperty(example = "null", value = "拍摄时间")
    public Long getShotTime() {
        return shotTime;
    }

    public void setShotTime(Long shotTime) {
        this.shotTime = shotTime;
    }

    public Attachment editTime(Long editTime) {
        this.editTime = editTime;
        return this;
    }

    /**
     * 拍摄时间
     *
     * @return editTime
     **/
    @ApiModelProperty(example = "null", value = "拍摄时间")
    public Long getEditTime() {
        return editTime;
    }

    public void setEditTime(Long editTime) {
        this.editTime = editTime;
    }

    public Attachment total(Integer total) {
        this.total = total;
        return this;
    }

    /**
     * 总数
     *
     * @return total
     **/
    @ApiModelProperty(example = "null", value = "总数")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Attachment hashcode(Integer hashcode) {
        this.hashcode = hashcode;
        return this;
    }

    /**
     * hashcode
     *
     * @return hashcode
     **/
    @ApiModelProperty(example = "null", value = "hashcode")
    public Integer getHashcode() {
        return hashcode;
    }

    public void setHashcode(Integer hashcode) {
        this.hashcode = hashcode;
    }

    public Attachment content(String content) {
        this.content = content;
        return this;
    }

    /**
     * 附件内容
     *
     * @return content
     **/
    @ApiModelProperty(example = "null", value = "附件内容")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                Objects.equals(this.mailId, attachment.mailId) &&
                Objects.equals(this.attachmentName, attachment.attachmentName) &&
                Objects.equals(this.attachmentSize, attachment.attachmentSize) &&
                Objects.equals(this.refrenceCount, attachment.refrenceCount) &&
                Objects.equals(this.tag, attachment.tag) &&
                Objects.equals(this.tagCount, attachment.tagCount) &&
                Objects.equals(this.sysTagCount, attachment.sysTagCount) &&
                Objects.equals(this.note, attachment.note) &&
                Objects.equals(this.filePath, attachment.filePath) &&
                Objects.equals(this.gps, attachment.gps) &&
                Objects.equals(this.camera, attachment.camera) &&
                Objects.equals(this.author, attachment.author) &&
                Objects.equals(this.createTime, attachment.createTime) &&
                Objects.equals(this.fileType, attachment.fileType) &&
                Objects.equals(this.company, attachment.company) &&
                Objects.equals(this.shotTime, attachment.shotTime) &&
                Objects.equals(this.editTime, attachment.editTime) &&
                Objects.equals(this.total, attachment.total) &&
                Objects.equals(this.hashcode, attachment.hashcode) &&
                Objects.equals(this.content, attachment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachmentId, mailId, attachmentName, attachmentSize, refrenceCount, tag, tagCount, sysTagCount, note, filePath, gps, camera, author, createTime, fileType, company, shotTime, editTime, total, hashcode, content);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Attachment {\n");

        sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
        sb.append("    mailId: ").append(toIndentedString(mailId)).append("\n");
        sb.append("    attachmentName: ").append(toIndentedString(attachmentName)).append("\n");
        sb.append("    attachmentSize: ").append(toIndentedString(attachmentSize)).append("\n");
        sb.append("    refrenceCount: ").append(toIndentedString(refrenceCount)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
        sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
        sb.append("    sysTagCount: ").append(toIndentedString(sysTagCount)).append("\n");
        sb.append("    note: ").append(toIndentedString(note)).append("\n");
        sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
        sb.append("    gps: ").append(toIndentedString(gps)).append("\n");
        sb.append("    camera: ").append(toIndentedString(camera)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    shotTime: ").append(toIndentedString(shotTime)).append("\n");
        sb.append("    editTime: ").append(toIndentedString(editTime)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    hashcode: ").append(toIndentedString(hashcode)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
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


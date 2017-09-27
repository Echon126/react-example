package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * CustomTag
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-31T03:02:20.140Z")

public class CustomTag {
    @JsonProperty("tagId")
    private String tagId = null;

    @JsonProperty("tagName")
    private String tagName = null;

    @JsonProperty("tagIcon")
    private String tagIcon = null;

    @JsonProperty("frequency")
    private Integer frequency = null;

    @JsonProperty("createTime")
    private Long createTime = null;

    @JsonProperty("lastUseTime")
    private Long lastUseTime = null;

    public CustomTag tagId(String tagId) {
        this.tagId = tagId;
        return this;
    }

    /**
     * 标签id
     *
     * @return tagId
     **/
    @ApiModelProperty(value = "标签id")
    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public CustomTag tagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    /**
     * 标签name
     *
     * @return tagName
     **/
    @ApiModelProperty(value = "标签name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public CustomTag tagIcon(String tagIcon) {
        this.tagIcon = tagIcon;
        return this;
    }

    /**
     * 标签icon
     *
     * @return tagIcon
     **/
    @ApiModelProperty(value = "标签icon")
    public String getTagIcon() {
        return tagIcon;
    }

    public void setTagIcon(String tagIcon) {
        this.tagIcon = tagIcon;
    }

    public CustomTag frequency(Integer frequency) {
        this.frequency = frequency;
        return this;
    }

    /**
     * 使用频率
     *
     * @return frequency
     **/
    @ApiModelProperty(value = "使用频率")
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public CustomTag createTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 创建时间
     *
     * @return createTime
     **/
    @ApiModelProperty(value = "创建时间")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public CustomTag lastUseTime(Long lastUseTime) {
        this.lastUseTime = lastUseTime;
        return this;
    }

    /**
     * 最后使用时间
     *
     * @return lastUseTime
     **/
    @ApiModelProperty(value = "最后使用时间")
    public Long getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Long lastUseTime) {
        this.lastUseTime = lastUseTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomTag customTag = (CustomTag) o;
        return Objects.equals(this.tagId, customTag.tagId) &&
                Objects.equals(this.tagName, customTag.tagName) &&
                Objects.equals(this.tagIcon, customTag.tagIcon) &&
                Objects.equals(this.frequency, customTag.frequency) &&
                Objects.equals(this.createTime, customTag.createTime) &&
                Objects.equals(this.lastUseTime, customTag.lastUseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagName, tagIcon, frequency, createTime, lastUseTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomTag {\n");

        sb.append("    tagId: ").append(toIndentedString(tagId)).append("\n");
        sb.append("    tagName: ").append(toIndentedString(tagName)).append("\n");
        sb.append("    tagIcon: ").append(toIndentedString(tagIcon)).append("\n");
        sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
        sb.append("    lastUseTime: ").append(toIndentedString(lastUseTime)).append("\n");
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


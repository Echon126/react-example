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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContactItem
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-21T07:16:57.704Z")
public class ContactItem {
    @SerializedName("contactId")
    private String contactId = null;

    @SerializedName("contactName")
    private String contactName = null;

    @SerializedName("contactMailAddr")
    private String contactMailAddr = null;

    @SerializedName("associateCount")
    private Integer associateCount = null;

    @SerializedName("notes")
    private String notes = null;

    @SerializedName("tag")
    private String tag = null;

    @SerializedName("tagCount")
    private Integer tagCount = null;

    @SerializedName("total")
    private Integer total = null;

    @SerializedName("relations")
    private List<ContactRelation> relations = new ArrayList<ContactRelation>();

    public ContactItem contactId(String contactId) {
        this.contactId = contactId;
        return this;
    }

    /**
     * 联系人id
     *
     * @return contactId
     **/
    @ApiModelProperty(example = "null", value = "联系人id")
    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public ContactItem contactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    /**
     * 联系人名称
     *
     * @return contactName
     **/
    @ApiModelProperty(example = "null", value = "联系人名称")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public ContactItem contactMailAddr(String contactMailAddr) {
        this.contactMailAddr = contactMailAddr;
        return this;
    }

    /**
     * 联系人邮箱
     *
     * @return contactMailAddr
     **/
    @ApiModelProperty(example = "null", value = "联系人邮箱")
    public String getContactMailAddr() {
        return contactMailAddr;
    }

    public void setContactMailAddr(String contactMailAddr) {
        this.contactMailAddr = contactMailAddr;
    }

    public ContactItem associateCount(Integer associateCount) {
        this.associateCount = associateCount;
        return this;
    }

    /**
     * 相关联的联系人数量
     *
     * @return associateCount
     **/
    @ApiModelProperty(example = "null", value = "相关联的联系人数量")
    public Integer getAssociateCount() {
        return associateCount;
    }

    public void setAssociateCount(Integer associateCount) {
        this.associateCount = associateCount;
    }

    public ContactItem notes(String notes) {
        this.notes = notes;
        return this;
    }

    /**
     * 批注内容
     *
     * @return notes
     **/
    @ApiModelProperty(example = "null", value = "批注内容")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ContactItem tag(String tag) {
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

    public ContactItem tagCount(Integer tagCount) {
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

    public ContactItem total(Integer total) {
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

    public ContactItem relations(List<ContactRelation> relations) {
        this.relations = relations;
        return this;
    }

    public ContactItem addRelationsItem(ContactRelation relationsItem) {
        this.relations.add(relationsItem);
        return this;
    }

    /**
     * 相关联的关系人列表
     *
     * @return relations
     **/
    @ApiModelProperty(example = "null", value = "相关联的关系人列表")
    public List<ContactRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<ContactRelation> relations) {
        this.relations = relations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactItem contactItem = (ContactItem) o;
        return Objects.equals(this.contactId, contactItem.contactId) &&
                Objects.equals(this.contactName, contactItem.contactName) &&
                Objects.equals(this.contactMailAddr, contactItem.contactMailAddr) &&
                Objects.equals(this.associateCount, contactItem.associateCount) &&
                Objects.equals(this.notes, contactItem.notes) &&
                Objects.equals(this.tag, contactItem.tag) &&
                Objects.equals(this.tagCount, contactItem.tagCount) &&
                Objects.equals(this.total, contactItem.total) &&
                Objects.equals(this.relations, contactItem.relations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, contactName, contactMailAddr, associateCount, notes, tag, tagCount, total, relations);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContactItem {\n");

        sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
        sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
        sb.append("    contactMailAddr: ").append(toIndentedString(contactMailAddr)).append("\n");
        sb.append("    associateCount: ").append(toIndentedString(associateCount)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
        sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    relations: ").append(toIndentedString(relations)).append("\n");
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


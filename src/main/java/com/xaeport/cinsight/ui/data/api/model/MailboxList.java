package com.xaeport.cinsight.ui.data.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MailboxList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class MailboxList {
    @JsonProperty("mailboxId")
    private String mailboxId = null;

    @JsonProperty("mailboxAddress")
    private String mailboxAddress = null;

    @JsonProperty("inboxCount")
    private Integer inboxCount = null;

    @JsonProperty("outboxCount")
    private Integer outboxCount = null;

    @JsonProperty("draftboxCount")
    private Integer draftboxCount = null;

    @JsonProperty("trashCount")
    private Integer trashCount = null;

    @JsonProperty("notes")
    private String notes = null;

    @JsonProperty("tags")
    private List<UseTag> tags = new ArrayList<UseTag>();

    public MailboxList mailboxId(String mailboxId) {
        this.mailboxId = mailboxId;
        return this;
    }

    /**
     * 邮箱id
     * @return mailboxId
     **/
    @ApiModelProperty(value = "邮箱id")
    public String getMailboxId() {
        return mailboxId;
    }

    public void setMailboxId(String mailboxId) {
        this.mailboxId = mailboxId;
    }

    public MailboxList mailboxAddress(String mailboxAddress) {
        this.mailboxAddress = mailboxAddress;
        return this;
    }

    /**
     * 邮箱名称
     * @return mailboxAddress
     **/
    @ApiModelProperty(value = "邮箱名称")
    public String getMailboxAddress() {
        return mailboxAddress;
    }

    public void setMailboxAddress(String mailboxAddress) {
        this.mailboxAddress = mailboxAddress;
    }

    public MailboxList inboxCount(Integer inboxCount) {
        this.inboxCount = inboxCount;
        return this;
    }

    /**
     * 收件箱邮件数量
     * @return inboxCount
     **/
    @ApiModelProperty(value = "收件箱邮件数量")
    public Integer getInboxCount() {
        return inboxCount;
    }

    public void setInboxCount(Integer inboxCount) {
        this.inboxCount = inboxCount;
    }

    public MailboxList outboxCount(Integer outboxCount) {
        this.outboxCount = outboxCount;
        return this;
    }

    /**
     * 发件箱邮件数量
     * @return outboxCount
     **/
    @ApiModelProperty(value = "发件箱邮件数量")
    public Integer getOutboxCount() {
        return outboxCount;
    }

    public void setOutboxCount(Integer outboxCount) {
        this.outboxCount = outboxCount;
    }

    public MailboxList draftboxCount(Integer draftboxCount) {
        this.draftboxCount = draftboxCount;
        return this;
    }

    /**
     * 草稿箱邮件数量
     * @return draftboxCount
     **/
    @ApiModelProperty(value = "草稿箱邮件数量")
    public Integer getDraftboxCount() {
        return draftboxCount;
    }

    public void setDraftboxCount(Integer draftboxCount) {
        this.draftboxCount = draftboxCount;
    }

    public MailboxList trashCount(Integer trashCount) {
        this.trashCount = trashCount;
        return this;
    }

    /**
     * 垃圾箱邮件数量
     * @return trashCount
     **/
    @ApiModelProperty(value = "垃圾箱邮件数量")
    public Integer getTrashCount() {
        return trashCount;
    }

    public void setTrashCount(Integer trashCount) {
        this.trashCount = trashCount;
    }

    public MailboxList notes(String notes) {
        this.notes = notes;
        return this;
    }

    /**
     * 批注
     * @return notes
     **/
    @ApiModelProperty(value = "批注")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public MailboxList tags(List<UseTag> tags) {
        this.tags = tags;
        return this;
    }

    public MailboxList addTagsItem(UseTag tagsItem) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MailboxList mailboxList = (MailboxList) o;
        return Objects.equals(this.mailboxId, mailboxList.mailboxId) &&
                Objects.equals(this.mailboxAddress, mailboxList.mailboxAddress) &&
                Objects.equals(this.inboxCount, mailboxList.inboxCount) &&
                Objects.equals(this.outboxCount, mailboxList.outboxCount) &&
                Objects.equals(this.draftboxCount, mailboxList.draftboxCount) &&
                Objects.equals(this.trashCount, mailboxList.trashCount) &&
                Objects.equals(this.notes, mailboxList.notes) &&
                Objects.equals(this.tags, mailboxList.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailboxId, mailboxAddress, inboxCount, outboxCount, draftboxCount, trashCount, notes, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailboxList {\n");

        sb.append("    mailboxId: ").append(toIndentedString(mailboxId)).append("\n");
        sb.append("    mailboxAddress: ").append(toIndentedString(mailboxAddress)).append("\n");
        sb.append("    inboxCount: ").append(toIndentedString(inboxCount)).append("\n");
        sb.append("    outboxCount: ").append(toIndentedString(outboxCount)).append("\n");
        sb.append("    draftboxCount: ").append(toIndentedString(draftboxCount)).append("\n");
        sb.append("    trashCount: ").append(toIndentedString(trashCount)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


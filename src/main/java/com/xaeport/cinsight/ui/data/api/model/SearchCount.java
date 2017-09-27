package com.xaeport.cinsight.ui.data.api.model;

import com.google.gson.annotations.SerializedName;
import com.xaeport.cinsight.ui.data.entity.Search;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * SearchCount
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class SearchCount {
    @SerializedName("mailCount")
    private Integer mailCount = 0;

    @SerializedName("attachmentCount")
    private Integer attachmentCount = 0;

    @SerializedName("mailboxCount")
    private Integer mailboxCount = 0;

    @SerializedName("contactCount")
    private Integer contactCount = 0;

    @SerializedName("searchToken")
    private String searchToken = null;

    public SearchCount mailCount(Integer mailCount) {
        this.mailCount = mailCount;
        return this;
    }

    /**
     * Get mailCount
     *
     * @return mailCount
     **/
    @ApiModelProperty(example = "null", value = "")
    public Integer getMailCount() {
        return mailCount;
    }

    public void setMailCount(Integer mailCount) {
        this.mailCount = mailCount;
    }

    public SearchCount attachmentCount(Integer attachmentCount) {
        this.attachmentCount = attachmentCount;
        return this;
    }

    /**
     * Get attachmentCount
     *
     * @return attachmentCount
     **/
    @ApiModelProperty(example = "null", value = "")
    public Integer getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(Integer attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public SearchCount mailboxCount(Integer mailboxCount) {
        this.mailboxCount = mailboxCount;
        return this;
    }

    /**
     * Get mailboxCount
     *
     * @return mailboxCount
     **/
    @ApiModelProperty(example = "null", value = "")
    public Integer getMailboxCount() {
        return mailboxCount;
    }

    public void setMailboxCount(Integer mailboxCount) {
        this.mailboxCount = mailboxCount;
    }

    public SearchCount contactCount(Integer contactCount) {
        this.contactCount = contactCount;
        return this;
    }

    /**
     * Get contactCount
     *
     * @return contactCount
     **/
    @ApiModelProperty(example = "null", value = "")
    public Integer getContactCount() {
        return contactCount;
    }

    public void setContactCount(Integer contactCount) {
        this.contactCount = contactCount;
    }

    public SearchCount searchToken(String searchToken) {
        this.searchToken = searchToken;
        return this;
    }

    /**
     * Get searchToken
     *
     * @return searchToken
     **/
    @ApiModelProperty(example = "null", value = "")
    public String getSearchToken() {
        return searchToken;
    }

    public void setSearchToken(String searchToken) {
        this.searchToken = searchToken;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchCount search = (SearchCount) o;
        return Objects.equals(this.mailCount, search.mailCount) &&
                Objects.equals(this.attachmentCount, search.attachmentCount) &&
                Objects.equals(this.mailboxCount, search.mailboxCount) &&
                Objects.equals(this.contactCount, search.contactCount) &&
                Objects.equals(this.searchToken, search.searchToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailCount, attachmentCount, mailboxCount, contactCount, searchToken);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Search {\n");

        sb.append("    mailCount: ").append(toIndentedString(mailCount)).append("\n");
        sb.append("    attachmentCount: ").append(toIndentedString(attachmentCount)).append("\n");
        sb.append("    mailboxCount: ").append(toIndentedString(mailboxCount)).append("\n");
        sb.append("    contactCount: ").append(toIndentedString(contactCount)).append("\n");
        sb.append("    searchToken: ").append(toIndentedString(searchToken)).append("\n");
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


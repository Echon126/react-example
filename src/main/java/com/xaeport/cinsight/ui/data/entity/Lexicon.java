package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Lexicon
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Lexicon {
    @JsonProperty("lexiconId")
    private String lexiconId = null;

    @JsonProperty("lexiconName")
    private String lexiconName = null;

    @JsonProperty("lexiconDescription")
    private String lexiconDescription = null;

    @JsonProperty("lexiconEnabled")
    private Boolean lexiconEnabled = null;

    @JsonProperty("createTime")
    private Long createTime = null;

    public Lexicon lexiconId(String lexiconId) {
        this.lexiconId = lexiconId;
        return this;
    }

    /**
     * 词库id
     *
     * @return lexiconId
     **/
    @ApiModelProperty(value = "词库id")
    public String getLexiconId() {
        return lexiconId;
    }

    public void setLexiconId(String lexiconId) {
        this.lexiconId = lexiconId;
    }

    public Lexicon lexiconName(String lexiconName) {
        this.lexiconName = lexiconName;
        return this;
    }

    /**
     * 词库名称
     *
     * @return lexiconName
     **/
    @ApiModelProperty(value = "词库名称")
    public String getLexiconName() {
        return lexiconName;
    }

    public void setLexiconName(String lexiconName) {
        this.lexiconName = lexiconName;
    }

    public Lexicon lexiconDescription(String lexiconDescription) {
        this.lexiconDescription = lexiconDescription;
        return this;
    }

    /**
     * 词库备注
     *
     * @return lexiconDescription
     **/
    @ApiModelProperty(value = "词库备注")
    public String getLexiconDescription() {
        return lexiconDescription;
    }

    public void setLexiconDescription(String lexiconDescription) {
        this.lexiconDescription = lexiconDescription;
    }

    public Lexicon lexiconEnabled(Boolean lexiconEnabled) {
        this.lexiconEnabled = lexiconEnabled;
        return this;
    }

    /**
     * 词库是否启用
     *
     * @return lexiconEnabled
     **/
    @ApiModelProperty(value = "词库是否启用")
    public Boolean getLexiconEnabled() {
        return lexiconEnabled;
    }

    public void setLexiconEnabled(Boolean lexiconEnabled) {
        this.lexiconEnabled = lexiconEnabled;
    }


    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexicon lexicon = (Lexicon) o;
        return Objects.equals(this.lexiconId, lexicon.lexiconId) &&
                Objects.equals(this.lexiconName, lexicon.lexiconName) &&
                Objects.equals(this.lexiconDescription, lexicon.lexiconDescription) &&
                Objects.equals(this.lexiconEnabled, lexicon.lexiconEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexiconId, lexiconName, lexiconDescription, lexiconEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Lexicon {\n");

        sb.append("    lexiconId: ").append(toIndentedString(lexiconId)).append("\n");
        sb.append("    lexiconName: ").append(toIndentedString(lexiconName)).append("\n");
        sb.append("    lexiconDescription: ").append(toIndentedString(lexiconDescription)).append("\n");
        sb.append("    lexiconEnabled: ").append(toIndentedString(lexiconEnabled)).append("\n");
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


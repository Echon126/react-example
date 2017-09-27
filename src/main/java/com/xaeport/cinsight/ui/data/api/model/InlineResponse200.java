package com.xaeport.cinsight.ui.data.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class InlineResponse200 {
    @JsonProperty("caseCode")
    private String caseCode = null;

    public InlineResponse200 caseCode(String caseCode) {
        this.caseCode = caseCode;
        return this;
    }

    /**
     * Get caseCode
     *
     * @return caseCode
     **/
    @ApiModelProperty(value = "")
    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineResponse200 inlineResponse200 = (InlineResponse200) o;
        return Objects.equals(this.caseCode, inlineResponse200.caseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse200 {\n");

        sb.append("    caseCode: ").append(toIndentedString(caseCode)).append("\n");
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


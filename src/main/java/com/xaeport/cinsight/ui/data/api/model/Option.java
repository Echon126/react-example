package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Option
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Option   {
  @JsonProperty("optionKey")
  private String optionKey = null;

  @JsonProperty("optionLabel")
  private String optionLabel = null;

  @JsonProperty("optionValue")
  private String optionValue = null;

  public Option optionKey(String optionKey) {
    this.optionKey = optionKey;
    return this;
  }

   /**
   * 配置项键名。全局唯一（取值=pluginId.optionId）
   * @return optionKey
  **/
  @ApiModelProperty(value = "配置项键名。全局唯一（取值=pluginId.optionId）")
  public String getOptionKey() {
    return optionKey;
  }

  public void setOptionKey(String optionKey) {
    this.optionKey = optionKey;
  }

  public Option optionLabel(String optionLabel) {
    this.optionLabel = optionLabel;
    return this;
  }

   /**
   * 配置项名称
   * @return optionLabel
  **/
  @ApiModelProperty(value = "配置项名称")
  public String getOptionLabel() {
    return optionLabel;
  }

  public void setOptionLabel(String optionLabel) {
    this.optionLabel = optionLabel;
  }

  public Option optionValue(String optionValue) {
    this.optionValue = optionValue;
    return this;
  }

   /**
   * 配置项键值
   * @return optionValue
  **/
  @ApiModelProperty(value = "配置项键值")
  public String getOptionValue() {
    return optionValue;
  }

  public void setOptionValue(String optionValue) {
    this.optionValue = optionValue;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Option option = (Option) o;
    return Objects.equals(this.optionKey, option.optionKey) &&
        Objects.equals(this.optionLabel, option.optionLabel) &&
        Objects.equals(this.optionValue, option.optionValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optionKey, optionLabel, optionValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Option {\n");
    
    sb.append("    optionKey: ").append(toIndentedString(optionKey)).append("\n");
    sb.append("    optionLabel: ").append(toIndentedString(optionLabel)).append("\n");
    sb.append("    optionValue: ").append(toIndentedString(optionValue)).append("\n");
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


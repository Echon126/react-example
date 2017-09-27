package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
/**
 * Load
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Load   {
  @JsonProperty("pluginName")
  private String pluginName = null;

  @JsonProperty("options")
  private List<Option> options = new ArrayList<Option>();

  public Load pluginName(String pluginName) {
    this.pluginName = pluginName;
    return this;
  }

   /**
   * 插件名称
   * @return pluginName
  **/
  @ApiModelProperty(value = "插件名称")
  public String getPluginName() {
    return pluginName;
  }

  public void setPluginName(String pluginName) {
    this.pluginName = pluginName;
  }

  public Load options(List<Option> options) {
    this.options = options;
    return this;
  }

  public Load addOptionsItem(Option optionsItem) {
    this.options.add(optionsItem);
    return this;
  }

   /**
   * Get options
   * @return options
  **/
  @ApiModelProperty(value = "")
  public List<Option> getOptions() {
    return options;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Load load = (Load) o;
    return Objects.equals(this.pluginName, load.pluginName) &&
        Objects.equals(this.options, load.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pluginName, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Load {\n");
    
    sb.append("    pluginName: ").append(toIndentedString(pluginName)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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


package com.xaeport.cinsight.ui.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Plugin
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Plugin {
    @JsonProperty("pluginId")
    private String pluginId = null;

    @JsonProperty("pluginName")
    private String pluginName = null;

    @JsonProperty("pluginDescription")
    private String pluginDescription = null;

    @JsonProperty("pluginEnabled")
    private Boolean pluginEnabled = null;

    @JsonProperty("createTime")
    private Long createTime = null;

    public Plugin pluginId(String pluginId) {
        this.pluginId = pluginId;
        return this;
    }

    /**
     * 插件id
     *
     * @return pluginId
     **/
    @ApiModelProperty(value = "插件id")
    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    public Plugin pluginName(String pluginName) {
        this.pluginName = pluginName;
        return this;
    }

    /**
     * 插件名称
     *
     * @return pluginName
     **/
    @ApiModelProperty(value = "插件名称")
    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public Plugin pluginDescription(String pluginDescription) {
        this.pluginDescription = pluginDescription;
        return this;
    }

    /**
     * 插件描述文本
     *
     * @return pluginDescription
     **/
    @ApiModelProperty(value = "插件描述文本")
    public String getPluginDescription() {
        return pluginDescription;
    }

    public void setPluginDescription(String pluginDescription) {
        this.pluginDescription = pluginDescription;
    }

    public Plugin pluginEnabled(Boolean pluginEnabled) {
        this.pluginEnabled = pluginEnabled;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 插件是否启用
     *
     * @return pluginEnabled
     **/
    @ApiModelProperty(value = "插件是否启用")
    public Boolean getPluginEnabled() {
        return pluginEnabled;
    }

    public void setPluginEnabled(Boolean pluginEnabled) {
        this.pluginEnabled = pluginEnabled;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Plugin plugin = (Plugin) o;
        return Objects.equals(this.pluginId, plugin.pluginId) &&
                Objects.equals(this.pluginName, plugin.pluginName) &&
                Objects.equals(this.pluginDescription, plugin.pluginDescription) &&
                Objects.equals(this.pluginEnabled, plugin.pluginEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pluginId, pluginName, pluginDescription, pluginEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Plugin {\n");

        sb.append("    pluginId: ").append(toIndentedString(pluginId)).append("\n");
        sb.append("    pluginName: ").append(toIndentedString(pluginName)).append("\n");
        sb.append("    pluginDescription: ").append(toIndentedString(pluginDescription)).append("\n");
        sb.append("    pluginEnabled: ").append(toIndentedString(pluginEnabled)).append("\n");
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


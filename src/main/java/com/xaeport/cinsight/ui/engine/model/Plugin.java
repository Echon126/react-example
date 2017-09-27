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
 * Plugin
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-21T07:16:57.704Z")
public class Plugin {
    @SerializedName("pluginName")
    private String pluginName = null;

    @SerializedName("options")
    private List<PluginOption> options = new ArrayList<PluginOption>();

    public Plugin pluginName(String pluginName) {
        this.pluginName = pluginName;
        return this;
    }

    /**
     * 插件名称，如：压缩包、全文索引、信息提取、领域词库
     *
     * @return pluginName
     **/
    @ApiModelProperty(example = "null", value = "插件名称，如：压缩包、全文索引、信息提取、领域词库")
    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public Plugin options(List<PluginOption> options) {
        this.options = options;
        return this;
    }

    public Plugin addOptionsItem(PluginOption optionsItem) {
        this.options.add(optionsItem);
        return this;
    }

    /**
     * 配置项集合
     *
     * @return options
     **/
    @ApiModelProperty(example = "null", value = "配置项集合")
    public List<PluginOption> getOptions() {
        return options;
    }

    public void setOptions(List<PluginOption> options) {
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
        Plugin plugin = (Plugin) o;
        return Objects.equals(this.pluginName, plugin.pluginName) &&
                Objects.equals(this.options, plugin.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pluginName, options);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Plugin {\n");

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


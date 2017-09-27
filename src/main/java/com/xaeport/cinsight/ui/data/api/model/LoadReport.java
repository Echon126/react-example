package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * LoadReport
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class LoadReport   {
  @JsonProperty("totalCount")
  private Integer totalCount = null;

  @JsonProperty("successCount")
  private Integer successCount = null;

  @JsonProperty("failCount")
  private Integer failCount = null;

  @JsonProperty("failFiles")
  private List<String> failFiles = new ArrayList<String>();

  public LoadReport totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * 数据文件总量
   * @return totalCount
  **/
  @ApiModelProperty(value = "数据文件总量")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public LoadReport successCount(Integer successCount) {
    this.successCount = successCount;
    return this;
  }

   /**
   * 装载成功数量
   * @return successCount
  **/
  @ApiModelProperty(value = "装载成功数量")
  public Integer getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(Integer successCount) {
    this.successCount = successCount;
  }

  public LoadReport failCount(Integer failCount) {
    this.failCount = failCount;
    return this;
  }

   /**
   * 装载失败数量
   * @return failCount
  **/
  @ApiModelProperty(value = "装载失败数量")
  public Integer getFailCount() {
    return failCount;
  }

  public void setFailCount(Integer failCount) {
    this.failCount = failCount;
  }

  public LoadReport failFiles(List<String> failFiles) {
    this.failFiles = failFiles;
    return this;
  }

  public LoadReport addFailFilesItem(String failFilesItem) {
    this.failFiles.add(failFilesItem);
    return this;
  }

   /**
   * Get failFiles
   * @return failFiles
  **/
  @ApiModelProperty(value = "")
  public List<String> getFailFiles() {
    return failFiles;
  }

  public void setFailFiles(List<String> failFiles) {
    this.failFiles = failFiles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoadReport loadReport = (LoadReport) o;
    return Objects.equals(this.totalCount, loadReport.totalCount) &&
        Objects.equals(this.successCount, loadReport.successCount) &&
        Objects.equals(this.failCount, loadReport.failCount) &&
        Objects.equals(this.failFiles, loadReport.failFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, successCount, failCount, failFiles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoadReport {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    successCount: ").append(toIndentedString(successCount)).append("\n");
    sb.append("    failCount: ").append(toIndentedString(failCount)).append("\n");
    sb.append("    failFiles: ").append(toIndentedString(failFiles)).append("\n");
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


package com.xaeport.cinsight.ui.data.entity;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Condition
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class Condition   {
  @JsonProperty("keyword")
  private String keyword = null;

  @JsonProperty("expression")
  private String expression = null;

  @JsonProperty("result")
  private String result = null;

  @JsonProperty("relation")
  private String relation = null;

  public Condition keyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

   /**
   * 关键词
   * @return keyword
  **/
  @ApiModelProperty(value = "关键词")
  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Condition expression(String expression) {
    this.expression = expression;
    return this;
  }

   /**
   * 表达式
   * @return expression
  **/
  @ApiModelProperty(value = "表达式")
  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public Condition result(String result) {
    this.result = result;
    return this;
  }

   /**
   * 条件值
   * @return result
  **/
  @ApiModelProperty(value = "条件值")
  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Condition relation(String relation) {
    this.relation = relation;
    return this;
  }

   /**
   * 条件关系
   * @return relation
  **/
  @ApiModelProperty(value = "条件关系")
  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Condition condition = (Condition) o;
    return Objects.equals(this.keyword, condition.keyword) &&
        Objects.equals(this.expression, condition.expression) &&
        Objects.equals(this.result, condition.result) &&
        Objects.equals(this.relation, condition.relation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyword, expression, result, relation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Condition {\n");
    
    sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
    sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
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


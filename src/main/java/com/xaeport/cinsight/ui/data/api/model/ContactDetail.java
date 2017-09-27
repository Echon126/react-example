package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
/**
 * ContactDetail
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:07:31.548Z")

public class ContactDetail   {
  @JsonProperty("relations")
  private List<ContactDetailRelation> relations = new ArrayList<ContactDetailRelation>();

  @JsonProperty("diagram")
  private List<Diagram> diagram = new ArrayList<Diagram>();

  @JsonProperty("tags")
  private List<UseTag> tags = new ArrayList<UseTag>();

  @JsonProperty("notes")
  private String notes = null;

  public ContactDetail relations(List<ContactDetailRelation> relations) {
    this.relations = relations;
    return this;
  }

  public ContactDetail addRelationsItem(ContactDetailRelation relationsItem) {
    this.relations.add(relationsItem);
    return this;
  }

   /**
   * 联系人关系列表
   * @return relations
  **/
  @ApiModelProperty(value = "联系人关系列表")
  public List<ContactDetailRelation> getRelations() {
    return relations;
  }

  public void setRelations(List<ContactDetailRelation> relations) {
    this.relations = relations;
  }

  public ContactDetail diagram(List<Diagram> diagram) {
    this.diagram = diagram;
    return this;
  }

  public ContactDetail addDiagramItem(Diagram diagramItem) {
    this.diagram.add(diagramItem);
    return this;
  }

   /**
   * 收发件数量趋势图
   * @return diagram
  **/
  @ApiModelProperty(value = "收发件数量趋势图")
  public List<Diagram> getDiagram() {
    return diagram;
  }

  public void setDiagram(List<Diagram> diagram) {
    this.diagram = diagram;
  }

  public ContactDetail tags(List<UseTag> tags) {
    this.tags = tags;
    return this;
  }

  public ContactDetail addTagsItem(UseTag tagsItem) {
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

  public ContactDetail notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * 批注内容
   * @return notes
  **/
  @ApiModelProperty(value = "批注内容")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactDetail contactDetail = (ContactDetail) o;
    return Objects.equals(this.relations, contactDetail.relations) &&
        Objects.equals(this.diagram, contactDetail.diagram) &&
        Objects.equals(this.tags, contactDetail.tags) &&
        Objects.equals(this.notes, contactDetail.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relations, diagram, tags, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactDetail {\n");
    
    sb.append("    relations: ").append(toIndentedString(relations)).append("\n");
    sb.append("    diagram: ").append(toIndentedString(diagram)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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


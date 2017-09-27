package com.xaeport.cinsight.ui.data.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Attribute
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T06:57:31.477Z")

public class Attribute {
    @JsonProperty("author")
    private String author = null;

    @JsonProperty("company")
    private String company = null;

    @JsonProperty("gps")
    private String gps = null;

    @JsonProperty("camera")
    private String camera = null;

    @JsonProperty("shotTime")
    private String shotTime = null;

    public Attribute author(String author) {
        this.author = author;
        return this;
    }

    /**
     * 作者
     *
     * @return author
     **/
    @ApiModelProperty(value = "作者")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Attribute company(String company) {
        this.company = company;
        return this;
    }

    /**
     * 公司
     *
     * @return company
     **/
    @ApiModelProperty(value = "公司")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Attribute gps(String gps) {
        this.gps = gps;
        return this;
    }

    /**
     * GPS
     *
     * @return gps
     **/
    @ApiModelProperty(value = "GPS")
    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Attribute camera(String camera) {
        this.camera = camera;
        return this;
    }

    /**
     * 相机型号
     *
     * @return camera
     **/
    @ApiModelProperty(value = "相机型号")
    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Attribute shotTime(String shotTime) {
        this.shotTime = shotTime;
        return this;
    }

    /**
     * 拍摄时间
     *
     * @return shotTime
     **/
    @ApiModelProperty(value = "拍摄时间")
    public String getShotTime() {
        return shotTime;
    }

    public void setShotTime(String shotTime) {
        this.shotTime = shotTime;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) o;
        return Objects.equals(this.author, attribute.author) &&
                Objects.equals(this.company, attribute.company) &&
                Objects.equals(this.gps, attribute.gps) &&
                Objects.equals(this.camera, attribute.camera) &&
                Objects.equals(this.shotTime, attribute.shotTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, company, gps, camera, shotTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Attribute {\n");

        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    gps: ").append(toIndentedString(gps)).append("\n");
        sb.append("    camera: ").append(toIndentedString(camera)).append("\n");
        sb.append("    shotTime: ").append(toIndentedString(shotTime)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


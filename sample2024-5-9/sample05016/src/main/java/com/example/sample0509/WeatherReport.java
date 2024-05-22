package com.example.sample0509;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherReport {
    @JsonProperty("publishingOffice")
    private String publishingOffice;

    @JsonProperty("reportDatetime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private ZonedDateTime reportDatetime;

    @JsonProperty("targetArea")
    private String targetArea;

    @JsonProperty("headlineText")
    private String headlineText;

    @JsonProperty("text")
    private String text;

    // ゲッターとセッター

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public ZonedDateTime getReportDatetime() {
        return reportDatetime;
    }

    public void setReportDatetime(ZonedDateTime reportDatetime) {
        this.reportDatetime = reportDatetime;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public void setHeadlineText(String headlineText) {
        this.headlineText = headlineText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


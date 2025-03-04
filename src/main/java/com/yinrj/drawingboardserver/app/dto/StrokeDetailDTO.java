package com.yinrj.drawingboardserver.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrokeDetailDTO {

  @JsonProperty("index")
  private Integer index;

  @JsonProperty("startTime")
  private String startTime;

  @JsonProperty("endTime")
  private String endTime;

  @JsonProperty("duration")
  private Integer duration;

  @JsonProperty("interval")
  private Integer interval;
}
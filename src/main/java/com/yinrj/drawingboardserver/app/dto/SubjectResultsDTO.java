package com.yinrj.drawingboardserver.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yinrj.drawingboardserver.app.dto.deserializer.StrokesDataDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Name: SubjectResultsDTO
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResultsDTO {

    @JsonProperty("exam_id")
    private String examId;

    @JsonProperty("student_id")
    private String studentId;

    @JsonProperty("subject_title")
    private String subjectTitle;

    @JsonProperty("img_name")
    private String imgName; // 图片名称

    @JsonProperty("used_time")
    private Long usedTime; // 使用时间

    @JsonProperty("drawn_strokes")
    private Long drawnStrokes; // 笔画数

    @JsonProperty("undo_count")
    private Long undoCount; // 撤销次数

    @JsonProperty("redo_count")
    private Long redoCount; // 重做次数

    @JsonProperty("first_stroke_time")
    private Long firstStrokeTime; // 第一笔落笔时间

    @JsonProperty("total_stroke_duration")
    private Long totalStrokeDuration; // 总笔画时长

    @JsonProperty("strokes_data")
    @JsonDeserialize(using = StrokesDataDeserializer.class)
    private List<StrokeDetailDTO> strokesData;
}

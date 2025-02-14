package com.yinrj.drawingboardserver.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String imgName;

    @JsonProperty("used_time")
    private Long usedTime;

    @JsonProperty("drawn_strokes")
    private Long drawnStrokes;

    @JsonProperty("undo_count")
    private Long undoCount;

    @JsonProperty("redo_count")
    private Long redoCount;
}

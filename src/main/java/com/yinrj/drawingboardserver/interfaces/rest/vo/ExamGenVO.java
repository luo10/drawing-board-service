package com.yinrj.drawingboardserver.interfaces.rest.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: ExamGenVO
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamGenVO {

    @JsonProperty("exam_id")
    private String examId;

}

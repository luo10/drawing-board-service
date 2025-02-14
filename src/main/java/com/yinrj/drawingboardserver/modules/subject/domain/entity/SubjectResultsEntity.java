package com.yinrj.drawingboardserver.modules.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: SubjectResultsEntity
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResultsEntity {

    private Long id;

    private String examId;

    private String studentId;

    private String subjectTitle;

    private String imgName;

    private String imgUrl;

    private Long usedTime;

    private Long drawnStrokes;

    private Long undoCount;

    private Long redoCount;

    private Long createTime;

    private Long updateTime;

}

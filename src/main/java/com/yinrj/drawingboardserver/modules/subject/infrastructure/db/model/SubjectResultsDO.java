package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: SubjectResultsDO
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResultsDO {

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

    private Long firstStrokeTime; // 第一笔落笔时间

    private Long totalStrokeDuration; // 总笔画时长

    private Long createTime;

    private Long updateTime;

}

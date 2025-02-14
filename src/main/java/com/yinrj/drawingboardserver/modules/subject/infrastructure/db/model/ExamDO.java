package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: ExamDO
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDO {

    private Long id;

    private String examId;

    private Integer flag;

    private String studentId;

    private Long createTime;

    private Long updateTime;

}

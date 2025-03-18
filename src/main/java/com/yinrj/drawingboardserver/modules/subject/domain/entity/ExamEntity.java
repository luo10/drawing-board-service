package com.yinrj.drawingboardserver.modules.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: ExamEntity
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamEntity {

    private Long id;

    private String examId;

    private Integer flag;

    private String studentId;

    private Long loginTime;

    private String ipAddress;

    private String deviceInfo;

    private Long createTime;

    private Long updateTime;

}

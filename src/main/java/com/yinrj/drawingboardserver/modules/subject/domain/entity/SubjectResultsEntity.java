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

    private Long id; // 主键ID

    private String examId; // 考试ID

    private String studentId; // 学生ID

    private String subjectTitle; // 科目标题

    private String imgName; // 图片名称

    private String imgUrl; // 图片URL地址

    private Long usedTime; // 学生作答使用的总时间(毫秒)

    private Long drawnStrokes; // 绘制的笔画数量

    private Long undoCount; // 撤销操作次数

    private Long redoCount; // 重做操作次数

    private Long firstStrokeTime; // 第一笔落笔时间

    private Long totalStrokeDuration; // 总笔画时长

    private Long createTime; // 记录创建时间

    private Long updateTime; // 记录更新时间

}

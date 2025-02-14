package com.yinrj.drawingboardserver.modules.subject.domain.repository;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.ExamEntity;

/**
 * Name: ExamRepository
 * Author: yinrongjie
 * Date: 2025/1/23
 */
public interface ExamRepository {

    /**
     * 插入考试记录
     *
     * @param examEntity 考试记录
     */
    void insert(ExamEntity examEntity);

}

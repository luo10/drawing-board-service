package com.yinrj.drawingboardserver.modules.subject.domain.repository;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.SubjectResultsEntity;

/**
 * Name: SubjectResultsRepository
 * Author: yinrongjie
 * Date: 2025/1/24
 */
public interface SubjectResultsRepository {

    /**
     * 插入
     *
     * @param subjectResults 实体
     */
    void insert(SubjectResultsEntity subjectResults);

    Long insertAndGetId(SubjectResultsEntity entity);

}

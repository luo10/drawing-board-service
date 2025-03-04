package com.yinrj.drawingboardserver.modules.subject.domain.service;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.SubjectResultsEntity;

/**
 * Name: SubjectResultsService
 * Author: yinrongjie
 * Date: 2025/1/24
 */
public interface SubjectResultsService {

    /**
     * 插入
     *
     * @param subjectResults 实体
     */
    void insert(SubjectResultsEntity subjectResults);

    /**
     * 插入并获取ID
     *
     * @param entity 实体
     * @return 生成的ID
     */
    Long insertAndGetId(SubjectResultsEntity entity);
}

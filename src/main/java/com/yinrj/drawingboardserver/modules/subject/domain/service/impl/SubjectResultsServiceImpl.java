package com.yinrj.drawingboardserver.modules.subject.domain.service.impl;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.SubjectResultsEntity;
import com.yinrj.drawingboardserver.modules.subject.domain.repository.SubjectResultsRepository;
import com.yinrj.drawingboardserver.modules.subject.domain.service.SubjectResultsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Name: SubjectResultsServiceImpl
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Service
@Slf4j
public class SubjectResultsServiceImpl implements SubjectResultsService {

    @Resource
    private SubjectResultsRepository subjectResultsRepository;

    /**
     * 插入
     *
     * @param subjectResults 实体
     */
    @Override
    public void insert(SubjectResultsEntity subjectResults) {
        subjectResultsRepository.insert(subjectResults);
    }
}

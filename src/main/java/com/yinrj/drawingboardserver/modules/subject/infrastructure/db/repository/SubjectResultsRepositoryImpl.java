package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.repository;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.SubjectResultsEntity;
import com.yinrj.drawingboardserver.modules.subject.domain.repository.SubjectResultsRepository;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.assembler.SubjectResultsAssembler;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao.SubjectResultsDAO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Name: SubjectResultsRepositoryImpl
 * Author: yinrongjie
 * Date: 2025/1/24
 */
@Component
@Slf4j
public class SubjectResultsRepositoryImpl implements SubjectResultsRepository {

    @Resource
    private SubjectResultsDAO subjectResultsDAO;

    @Resource
    private SubjectResultsAssembler subjectResultsAssembler;

    /**
     * 插入
     *
     * @param subjectResults 实体
     */
    @Override
    public void insert(SubjectResultsEntity subjectResults) {
        subjectResultsDAO.insertSubjectResults(subjectResultsAssembler.toDO(subjectResults));
    }
}

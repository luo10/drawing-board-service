package com.yinrj.drawingboardserver.modules.subject.infrastructure.db.repository;

import com.yinrj.drawingboardserver.modules.subject.domain.entity.ExamEntity;
import com.yinrj.drawingboardserver.modules.subject.domain.repository.ExamRepository;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.assembler.ExamAssembler;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.dao.ExamDAO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Name: ExamRepositoryImpl
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Component
@Slf4j
public class ExamRepositoryImpl implements ExamRepository {

    @Resource
    private ExamDAO examDAO;

    @Resource
    private ExamAssembler examAssembler;

    /**
     * 插入考试记录
     *
     * @param examEntity 考试记录
     */
    @Override
    public void insert(ExamEntity examEntity) {
        examDAO.insertExam(examAssembler.toDO(examEntity));
    }
}

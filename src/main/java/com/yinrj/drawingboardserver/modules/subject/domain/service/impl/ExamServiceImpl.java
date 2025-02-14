package com.yinrj.drawingboardserver.modules.subject.domain.service.impl;

import com.yinrj.drawingboardserver.common.utils.CommonUtils;
import com.yinrj.drawingboardserver.modules.subject.domain.assembler.SubjectDomainAssembler;
import com.yinrj.drawingboardserver.modules.subject.domain.repository.ExamRepository;
import com.yinrj.drawingboardserver.modules.subject.domain.service.ExamService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Name: ExamServiceImpl
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Service
@Slf4j
public class ExamServiceImpl implements ExamService {



    @Resource
    private ExamRepository examRepository;

    @Resource
    private SubjectDomainAssembler subjectDomainAssembler;

    /**
     * 生成考试
     *
     * @param studentId 学号
     * @return 考试Id
     */
    @Override
    public String generateExam(String studentId) {
        try {
            String examId = CommonUtils.generateRandomString(16);
            examRepository.insert(subjectDomainAssembler.convert2ExamEntity(studentId, examId));
            log.info("generate exam success. examId: {}, studentId: {}", examId, studentId);
            return examId;
        } catch (Exception e) {
            log.error("generate exam error. studentId: {}", studentId, e);
        }
        return null;

    }
}

package com.yinrj.drawingboardserver.modules.subject.domain.service.impl;

import com.yinrj.drawingboardserver.modules.subject.domain.service.ExamService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamServiceImplTest {

    @Resource
    private ExamService examService;


    @Test
    void testGenerateExam() {
        String examId = examService.generateExam("4444");
        assertNotNull(examId);
    }

}
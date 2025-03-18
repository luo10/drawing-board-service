package com.yinrj.drawingboardserver.modules.subject.domain.service.impl;

import com.yinrj.drawingboardserver.modules.subject.domain.service.ExamService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

@SpringBootTest
class ExamServiceImplTest {

    @Resource
    private ExamService examService;

    @Test
    @Disabled
    void testGenerateExam() {
        String examId = examService.generateExam("4444", 1L, "1234567890", "1234567890");
        assertNotNull(examId);
    }

}
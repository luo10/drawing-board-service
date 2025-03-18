package com.yinrj.drawingboardserver.modules.subject.domain.service.impl;

import com.yinrj.drawingboardserver.common.utils.CommonUtils;
import com.yinrj.drawingboardserver.modules.subject.domain.assembler.SubjectDomainAssembler;
import com.yinrj.drawingboardserver.modules.subject.domain.repository.ExamRepository;
import com.yinrj.drawingboardserver.modules.subject.domain.service.ExamService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * @param studentId  学号
     * @param loginTime  登录时间
     * @param ipAddress  IP地址
     * @param deviceInfo 设备信息
     * @return 考试Id
     */
    @Override
    public String generateExam(String studentId, Long loginTime, String ipAddress, String deviceInfo) {
        try {
            String examId = CommonUtils.generateRandomString(16);
            examRepository.insert(
                    subjectDomainAssembler.convert2ExamEntity(studentId, examId, loginTime, ipAddress, deviceInfo));
            log.info("generate exam success. examId: {}, studentId: {}, loginTime: {}, ipAddress: {}, deviceInfo: {}",
                    examId, studentId, loginTime, ipAddress, deviceInfo);
            return examId;
        } catch (Exception e) {
            log.error("generate exam error. studentId: {}, loginTime: {}, ipAddress: {}, deviceInfo: {}",
                    studentId, loginTime, ipAddress, deviceInfo, e);
        }
        return null;
    }
}

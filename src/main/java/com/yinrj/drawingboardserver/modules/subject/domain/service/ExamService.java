package com.yinrj.drawingboardserver.modules.subject.domain.service;

/**
 * Name: ExamService
 * Author: yinrongjie
 * Date: 2025/1/23
 */
public interface ExamService {

    /**
     * 生成考试
     *
     * @param studentId  学号
     * @param loginTime  登录时间
     * @param ipAddress  IP地址
     * @param deviceInfo 设备信息
     * @return 考试Id
     */
    String generateExam(String studentId, Long loginTime, String ipAddress, String deviceInfo);

}

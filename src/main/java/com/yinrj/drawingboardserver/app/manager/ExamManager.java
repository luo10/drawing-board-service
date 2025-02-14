package com.yinrj.drawingboardserver.app.manager;

import com.yinrj.drawingboardserver.app.assembler.SubjectAssembler;
import com.yinrj.drawingboardserver.app.dto.SubjectResultsDTO;
import com.yinrj.drawingboardserver.common.enums.StatusCodeEnum;
import com.yinrj.drawingboardserver.common.exception.CommonException;
import com.yinrj.drawingboardserver.common.utils.CommonUtils;
import com.yinrj.drawingboardserver.interfaces.rest.vo.ExamGenVO;
import com.yinrj.drawingboardserver.modules.oss.domain.service.OssService;
import com.yinrj.drawingboardserver.modules.subject.domain.service.ExamService;
import com.yinrj.drawingboardserver.modules.subject.domain.service.SubjectResultsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Name: ExamManager
 * Author: yinrongjie
 * Date: 2025/1/23
 */
@Component
@Slf4j
public class ExamManager {

    @Resource
    private ExamService examService;

    @Resource
    private SubjectResultsService subjectResultsService;

    @Resource
    private OssService ossService;

    @Resource
    private SubjectAssembler subjectAssembler;

    public ExamGenVO generateExam(String studentId) {
        return new ExamGenVO(examService.generateExam(studentId));
    }

    public void saveSubjectsResult(MultipartFile file, SubjectResultsDTO subjectResultsDTO) {
        try {
            var inputStream = file.getInputStream();
            var fileName = CommonUtils.generateRandomString(5);
            var url = ossService.upload(inputStream, fileName);
            var entity = subjectAssembler.convert2ResultsEntity(subjectResultsDTO, url);
            subjectResultsService.insert(entity);
        } catch (Exception e) {
            log.error("saveSubjectsResult error. studentId: {}", subjectResultsDTO.getStudentId(), e);
            throw new CommonException(StatusCodeEnum.SYSTEM_ERROR, "上传失败", e);
        }

    }
}

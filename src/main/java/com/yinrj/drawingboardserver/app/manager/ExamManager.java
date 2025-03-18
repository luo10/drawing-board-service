package com.yinrj.drawingboardserver.app.manager;

import com.yinrj.drawingboardserver.app.assembler.SubjectAssembler;
import com.yinrj.drawingboardserver.app.dto.StrokeDetailDTO;
import com.yinrj.drawingboardserver.app.dto.SubjectResultsDTO;
import com.yinrj.drawingboardserver.common.enums.StatusCodeEnum;
import com.yinrj.drawingboardserver.common.exception.CommonException;
import com.yinrj.drawingboardserver.common.utils.CommonUtils;
import com.yinrj.drawingboardserver.interfaces.rest.vo.ExamGenVO;
import com.yinrj.drawingboardserver.modules.oss.domain.service.OssService;
import com.yinrj.drawingboardserver.modules.subject.domain.service.ExamService;
import com.yinrj.drawingboardserver.modules.subject.domain.service.StrokeDetailService;
import com.yinrj.drawingboardserver.modules.subject.domain.service.SubjectResultsService;
import com.yinrj.drawingboardserver.modules.subject.infrastructure.db.model.StrokeDetailDO;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private StrokeDetailService strokeDetailService;

    public ExamGenVO generateExam(String studentId, Long loginTime, String ipAddress, String deviceInfo) {
        return new ExamGenVO(examService.generateExam(studentId, loginTime, ipAddress, deviceInfo));
    }

    /**
     * 保存学生的科目作答结果
     * 
     * @param file              学生提交的绘画作品图片文件
     * @param subjectResultsDTO 包含考试信息和绘画数据的DTO对象
     */
    public void saveSubjectsResult(MultipartFile file, SubjectResultsDTO subjectResultsDTO) {

        try {
            // 获取上传文件的输入流
            var inputStream = file.getInputStream();
            // 生成随机文件名（5个字符）防止文件名冲突
            var fileName = CommonUtils.generateRandomString(5);
            // 调用OSS服务将文件上传到云存储，并获取返回的访问URL
            var url = ossService.upload(inputStream, fileName);
            // 将DTO对象和图片URL转换为数据库实体对象
            var entity = subjectAssembler.convert2ResultsEntity(subjectResultsDTO, url);
            // 保存主表数据并获取生成的ID
            Long subjectResultId = subjectResultsService.insertAndGetId(entity);

            // 处理笔画详情数据
            if (subjectResultsDTO.getStrokesData() != null && !subjectResultsDTO.getStrokesData().isEmpty()) {
                List<StrokeDetailDO> strokeDetails = convertToStrokeDetailEntities(
                        subjectResultsDTO.getStrokesData(), subjectResultId);

                strokeDetailService.batchInsert(strokeDetails);
            }
        } catch (Exception e) {
            // 记录错误日志，包含学生ID信息
            log.error("saveSubjectsResult error. studentId: {}", subjectResultsDTO.getStudentId(), e);
            // 抛出自定义异常，向前端返回友好的错误信息
            throw new CommonException(StatusCodeEnum.SYSTEM_ERROR, "上传失败", e);
        }

    }

    private List<StrokeDetailDO> convertToStrokeDetailEntities(
            List<StrokeDetailDTO> strokesData, Long subjectResultId) {
        return strokesData.stream()
                .map(dto -> {
                    StrokeDetailDO entity = new StrokeDetailDO();
                    entity.setSubjectResultId(subjectResultId);
                    entity.setStrokeIndex(dto.getIndex());
                    // 转换ISO 8601时间格式为时间戳
                    entity.setStartTime(parseIsoTime(dto.getStartTime()));
                    entity.setEndTime(parseIsoTime(dto.getEndTime()));
                    entity.setDuration(dto.getDuration());
                    entity.setIntervalTime(dto.getInterval());
                    return entity;
                })
                .collect(Collectors.toList());
    }

    private Long parseIsoTime(String isoTime) {
        try {
            return Instant.parse(isoTime).toEpochMilli();
        } catch (Exception e) {
            log.error("解析ISO时间失败: {}", isoTime, e);
            return 0L;
        }
    }
}
